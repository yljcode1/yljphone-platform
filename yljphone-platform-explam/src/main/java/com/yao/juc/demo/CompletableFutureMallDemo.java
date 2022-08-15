package com.yao.juc.demo;

import lombok.Getter;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 1、需求
 * 1.1 同一产品，同时搜索出同款产品在各大电商平台的售价
 * 1.2 同一产品，同时搜索出本产品在同一电商平台下，各个入驻商家的售价多少
 * 2、输出：结果希望时同款产品在不同地方的价清单，返回一个List<String>
 *
 * @date: 2022/8/15
 * @author: yao
 */
public class CompletableFutureMallDemo {
    static List<NetMall> netMallList = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dangdang"),
            new NetMall("taobao"),
            new NetMall("pdd"),
            new NetMall("taote")
    );

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> list1 = getPrice(netMallList, "mysql");
        for (String element : list1) {
            System.out.println(element);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("-----costTime: " + (endTime - startTime) + "毫秒");
        System.out.println("-------------------------------------------");
        long startTime2 = System.currentTimeMillis();
        List<String> list2 = getPriceByCompletableFuture(netMallList, "mysql");
        for (String element : list2) {
            System.out.println(element);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("-----costTime: " + (endTime2 - startTime2) + "毫秒");

    }

    public static List<String> getPrice(List<NetMall> list, String productName) {
        return list.stream().map(
                netMall -> String.format(productName + " in %s price is %.2f", netMall.getNetMallName(), netMall.calcPrice(productName))
        ).collect(Collectors.toList());
    }

    public static List<String> getPriceByCompletableFuture(List<NetMall> list, String productName) {
        return list.stream().map(netMall -> CompletableFuture.supplyAsync(() -> String.format(productName + " in %s price is %.2f", netMall.getNetMallName(), netMall.calcPrice(productName))))
                .collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
}

class NetMall {
    @Getter
    private String netMallName;

    public NetMall(String netMallName) {
        this.netMallName = netMallName;
    }

    public double calcPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}
