package com.yao.lock.demo;

import java.util.concurrent.CountDownLatch;

/**
 * 6个同学陆续离开教室之后，班长才能锁门
 *
 * @date: 2022/8/31
 * @author: yao
 */
public class CountDownLacherDemo {
    // 班长先锁门走了
    //    public static void main(String[] args) {
//        for (int i = 1; i <= 6; i++) {
//            new Thread(() -> System.out.println(Thread.currentThread().getName() + " 号同学离开了教室"), String.valueOf(i)).start();
//        }
//        System.out.println(Thread.currentThread().getName() + "班长锁门走人了");
//    }
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= countDownLatch.getCount(); i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "号同学离开了教室");
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        // 等待countDownLatch减少成0
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "班长锁门走人了");
    }
}
