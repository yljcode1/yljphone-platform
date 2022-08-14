package com.yao.juc.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @date: 2022/8/14
 * @author: yao
 */
public class FutureDemo {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread2());
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();
    }

}

class MyThread implements Runnable {
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<String> {


    @Override
    public String call() throws Exception {
        System.out.println("---come in call()");
        return "hello";
    }
}
