package com.yao;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池实例
 *
 * @date: 2022/9/8
 * @author: yao
 */
public class poolDemo {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.submit(() -> {
//            System.out.println("Hello");
//        });
//        Executors.newSingleThreadExecutor()
//        Executors.newFixedThreadPool();
//        Executors.newScheduledThreadPool();
        Executors.newCachedThreadPool();
    }

    /**
     * 创建一池多线程
     *
     * @param nThreads 线程池数量
     * @return 线程池
     */
    public Executor getNewFixedThreadPool(int nThreads) {
        return Executors.newFixedThreadPool(nThreads);
    }

    /**
     * 创建一池一线程
     *
     * @return 线程池
     */
    public Executor getNewSingleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    /**
     * 创建延迟线程池
     *
     * @return 线程池
     */
    public Executor getNewScheduledThreadPool(int coolSize) {
        return Executors.newScheduledThreadPool(coolSize);
    }
}

