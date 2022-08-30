package com.yao.lock.demo;

import java.util.Arrays;

/**
 * @date: 2022/8/30
 * @author: yao
 */
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        Source source = new Source();

//        for (String s : Arrays.asList("AA", "bb")) new Thread(source::addOne, s).start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    source.addOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    source.subOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "b").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    source.addOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "c").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    source.subOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "d").start();
    }
}

//资源类
class Source {
    int num = 0;

    // 加1方法
    // 判断，干活，通知
    public synchronized void addOne() throws InterruptedException {
//        if (num == 0) {
//            num++;
//        }
        while (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "::" + num);
        this.notifyAll();
    }

    // 减1方法
    public synchronized void subOne() throws InterruptedException {
        while (num != 1) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "::" + num);
        this.notifyAll();
    }
}
