package com.yao.lock.demo;

/**
 * 可重入案例
 *
 * @date: 2022/8/30
 * @author: yao
 */
public class ReentrantDemo {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + "外部");
                synchronized (o) {
                    System.out.println(Thread.currentThread().getName() + "中部");
                    synchronized (o) {
                        System.out.println(Thread.currentThread().getName() + "内部");
                    }
                }
            }
        }).start();
    }
}
