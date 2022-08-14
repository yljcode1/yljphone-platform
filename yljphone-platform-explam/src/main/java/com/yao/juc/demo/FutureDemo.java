package com.yao.juc.demo;

import java.util.concurrent.*;

/**
 * @date: 2022/8/14
 * @author: yao
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService ex = Executors.newFixedThreadPool(3);
        FutureTask<String> futureTask = new FutureTask<>(new MyThread2());
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();
        System.out.println(futureTask.get());
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
