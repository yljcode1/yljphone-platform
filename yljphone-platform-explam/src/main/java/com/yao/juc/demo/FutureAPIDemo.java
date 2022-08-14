package com.yao.juc.demo;

import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @date: 2022/8/14
 * @author: yao
 */
public class FutureAPIDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            System.out.println(Thread.currentThread().getName() + "\t ----come in");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task over";
        });
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();
//        System.out.println(Thread.currentThread().getName() + "\t --- 忙其他任务");
//        System.out.println(futureTask.get()); // 一旦调用get方法，非要等到结果才会离开，不管你是否完成计算，容易程序阻塞

        // 实际项目中
        while (true) {
            if (futureTask.isDone()) {
                System.out.println(futureTask.get());
                break;
            } else {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("正在处理当中");
            }
        }
    }
}
