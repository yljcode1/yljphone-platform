package com.yao.lock.demo;

/**
 * @date: 2022/8/19
 * @author: yao
 */
public class LockSyncDemo {
    Object object = new Object();

    public void m1() {
        synchronized (object) {
            System.out.println("-----hello synchronized code block");
        }
    }

    public static void main(String[] args) {

    }
}
