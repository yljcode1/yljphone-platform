package com.yao.juc.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFutureAPI的API
 *
 * @date: 2022/8/15
 * @author: yao
 */
public class CompletableFutureAPIDemo {
    public static void main(String[] args) {
        // 异步任务 有返回值
        CompletableFuture.supplyAsync(() -> {
            // doSomething
            return "123";
        });
        // 异步任务 无返回
        CompletableFuture.runAsync(() -> {
            // doSomething;
        });
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("1111");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
            // 拿到上一个结果，计算结果存在依赖关系，这两个线程串行化
        }).thenApply(f -> {
            System.out.println("222");
            return f + 2;
        }).thenApply(f -> {
            System.out.println("333");
            return f + 3;
        }).whenComplete((v, e) -> {
            if (v == null) {
                System.out.println("-----计算结果:" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });
        System.out.println(Thread.currentThread().getName() + "---------主线程先去忙其他任务");
    }
}
