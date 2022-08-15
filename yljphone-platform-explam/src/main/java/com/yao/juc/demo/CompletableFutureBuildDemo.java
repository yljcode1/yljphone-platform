package com.yao.juc.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @date: 2022/8/14
 * @author: yao
 */
public class CompletableFutureBuildDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个不完全的completableFuture 不推荐
//        CompletableFuture<Object> objectCompletableFuture = new CompletableFuture<>();
        // 四种创建CompletableFuture的静态方法
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> { // 业务执行几秒钟线程
//            System.out.println(Thread.currentThread().getName());
//            try {
//                TimeUnit.MILLISECONDS.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        System.out.println(completableFuture.get());
//    }
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            // 暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        System.out.println(stringCompletableFuture.get());
    }
}
