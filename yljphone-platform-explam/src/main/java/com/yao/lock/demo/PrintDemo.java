package com.yao.lock.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @date: 2022/8/30
 * @author: yao
 */
public class PrintDemo {
}

class locked {
    private int flag = 0;
    Lock lock = new ReentrantLock();

    public void print() {
        try {
            lock.lock();
//            System.out.println(Thread.currentThread().getName() + "::");
            while (flag != 0) {
            }
//            flag++;
        } finally {
            lock.unlock();
        }
    }
}


