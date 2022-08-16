package com.yao.juc.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @date: 2022/8/16
 * @author: yao
 */
public class CompletableFutureUseDemo {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            // doSomeAndReturn
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new Student();
        }).thenApply(x -> {
            // addSomething
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).whenComplete((x, e) -> {
            if (x.isEmpty()) {
                // doSomething
            }
        }).exceptionally(throwable -> {
            throwable.printStackTrace();
            System.out.println("任務出錯");
            return null;
        });
    }
}
