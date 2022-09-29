package com.yao.juc.demo;

import java.util.concurrent.TimeUnit;

/**
 * 验证volatile的线程可见性
 *
 * @date: 2022/9/13
 * @author: yao
 */
public class InterruptDemo {
    public static boolean isStop = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (true) {
                if (isStop) {
                    System.out.println(Thread.currentThread().getName() + "\t isStop 被修改成true，程序停止");
                    break;
                }
                System.out.println(" t1 --------hello volatile");
            }
        }, "t1").start();

        TimeUnit.MILLISECONDS.sleep(3L);
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(20L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isStop = true;
        }, "t2").start();
    }

}
