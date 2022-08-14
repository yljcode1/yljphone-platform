package com.yao.juc.demo;

/**
 * @date: 2022/8/13
 * @author: yao
 */
public class ThreadBaseDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

        }, "t1");
        thread.start();
    }
}
