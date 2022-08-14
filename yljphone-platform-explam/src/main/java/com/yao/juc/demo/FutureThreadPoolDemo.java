package com.yao.juc.demo;

import java.util.Timer;
import java.util.concurrent.*;

/**
 * @date: 2022/8/14
 * @author: yao
 */
public class FutureThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        m();
        m2();
    }

    private static void m2() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return "task1 over";
        });
        FutureTask<String> futureTask2 = new FutureTask<String>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return "task2 over";
        });
        FutureTask<String> futureTask3 = new FutureTask<String>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return "task3 over";
        });

        executor.submit(futureTask);
        executor.submit(futureTask2);
        executor.submit(futureTask3);
        System.out.println(futureTask.get());
        System.out.println(futureTask2.get());
        System.out.println(futureTask3.get());
        long endTime = System.currentTimeMillis();
        System.out.println("----costTime: " + (endTime - startTime) + "毫秒");
        System.out.println(Thread.currentThread().getName() + "\t --end");
    }

    private static void m() {
        // 3个任务，目前就一个线程main来处理
        long startTime = System.currentTimeMillis();
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("----costTime: " + (endTime - startTime) + "毫秒");
        System.out.println(Thread.currentThread().getName() + "\t --end");
    }
}
