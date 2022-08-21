package com.yao.lock.demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 售票模拟
 *
 * @date: 2022/8/20
 * @author: yao
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        }, "b").start();
        new Thread(() -> {
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        }, "c").start();
    }
}

class Ticket {
    private int number = 50;
    ReentrantLock lock = new ReentrantLock(true);

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出去第:" + (number--) + "张票\t还剩下:" + number);
            }
        } finally {
            lock.unlock();
        }
    }
}



