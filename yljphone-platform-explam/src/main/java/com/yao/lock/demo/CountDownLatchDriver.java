package com.yao.lock.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 开始信号，阻止任何工人进行，直到司机准备好他们继续进行
 *
 * @date: 2022/8/31
 * @author: yao
 */
public class CountDownLatchDriver {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new TaskWorker(startSignal, doneSignal)).start();
        }
        System.out.println("countDown before");
        startSignal.countDown();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("await before");
        /**
         * 1、由于doneSignal里面的初始count=5，所以主线程在此会阻塞。
         * 2、当所有的子线程执行完（doneSignal.countDown()）之后，此时的count=0。所以后面代码可以继续执行。
         */
        doneSignal.await();
        System.out.println("await after");
    }
}

class TaskWorker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public TaskWorker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            /**
             * 1、刚进来的时候，由于startSignal的count=1。所以await()方法阻塞于此。
             * 2、当主线程执行了startSignal.countDown();此时的startSignal的count=0。所以子线程可以正常运行。
             */
            startSignal.await();
            doSomeWork();
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doSomeWork() {
        System.out.println("in run method: " + Thread.currentThread().getName());
    }
}


