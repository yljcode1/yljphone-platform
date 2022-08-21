package com.yao.lock.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁案例
 *
 * @date: 2022/8/21
 * @author: yao
 */
public class DeadLockDemo {


    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            while (true) {
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "被锁住了");
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b) {
                        System.out.println(Thread.currentThread().getName() + "被锁住了");
                    }
                }

            }
        }).start();
        new Thread(() -> {
            while (true) {
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "被锁住了");
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (a) {
                        System.out.println(Thread.currentThread().getName() + "被锁住了");
                    }
                }
            }
        }).start();
    }
}
