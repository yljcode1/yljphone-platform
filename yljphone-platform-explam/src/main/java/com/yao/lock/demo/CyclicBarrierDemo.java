package com.yao.lock.demo;

import java.util.concurrent.CyclicBarrier;

/**
 * 集齐七颗龙珠便可以召唤神龙
 *
 * @date: 2022/8/31
 * @author: yao
 */
public class CyclicBarrierDemo {
    private final static int NUMBER = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, () ->
                // 集齐后需要执行的任务
                System.out.println("********集齐七颗龙珠就可以召唤神龙"));
        for (int i = 1; i <= NUMBER; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "星龙珠被集齐了");
                    // 当有七个await时，执行new里面的方法
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }

}
