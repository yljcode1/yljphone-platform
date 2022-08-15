package com.yao.juc.demo;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @date: 2022/8/15
 * @author: yao
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName() + "---come in");
//            int result = ThreadLocalRandom.current().nextInt();
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("---1秒钟之后出结果" + result);
//            return result;
//        });
//        System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
//        System.out.println(integerCompletableFuture.get());
    }

    /**
     * whenComplete 当上一个任务完成时，调用whenComplete，
     * 相比于FutureTask不用isDone()轮询查看任务是否完成
     * exceptionally出异常处理
     */
    @Test
    public void testWhenComplete() throws ExecutionException, InterruptedException {
        // 需要在main线程
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "---come in");
                // 卖鱼花费时间3s
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "createFish";
//            return new Object();
            }, executorService).whenComplete((v, e) -> {
                if (StringUtils.isNotBlank(v)) {
                    System.out.println(Thread.currentThread().getName() + "----come in");
                    try {
                        // 做鱼1s
                        System.out.println("正在cooking-fish");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("鱼做完了");
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    //
                }
            }).exceptionally(throwable -> {
                throwable.printStackTrace();
                System.out.println("异常情况" + throwable.getCause() + "\t" + throwable.getMessage());
                return null;
            });
            System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        // ForkJoinPool线程当主线程结束时，相当于一个守护线程，会关闭
        // 延长主线程
//        TimeUnit.SECONDS.sleep(10);
//        System.out.println(stringCompletableFuture.get());
    }
}
