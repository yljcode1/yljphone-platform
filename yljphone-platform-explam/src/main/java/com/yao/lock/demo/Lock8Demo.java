package com.yao.lock.demo;

import java.util.concurrent.TimeUnit;

/**
 * @date: 2022/8/18
 * @author: yao
 */

/**
 * 题目：谈谈你对多线程的理解，8锁案例说明
 * 口诀：线程 操作 资源类
 * 8锁案例说明：
 * 1、标准访问有ab两个线程，请问先打印邮箱还是短信
 * 2、sendEmail方法中加入暂停3秒钟，请问先打印邮件还是短信
 * 有且只有一个线程能够使用资源类（加上synchronized方法的都会等待）
 * 3、添加一个普通方法hello，请问先打印邮箱还是hello
 * 4、有两部手机，先打印邮件还是短信
 * 5、两个静态同步方法，1部手机，请问先打印邮件还是短信
 * 6、两个静态同步方法，2部手机，请问先打印邮件还是短信
 * 7、有1个静态同步方法，有1个普通同步方法，有1部手机，请问先打印邮箱还是短信
 * 8、有1个静态同步方法，有一个普通同步方法，有两部手机，先打印邮箱还是短信
 * <p>
 * 笔记总结：
 * 1-2
 * 一个对象里面如果有多个synchronized方法，某一时刻内，只要一个线程去调用其中的synchronized方法，其他线程只能等待，
 * 换一句话说，某一个时刻内，只能有唯一一个线程去访问折现synchronized方法。锁的是当前对象this，被锁定后，其他的线程都不能
 * 进入当前对象的其他的synchronized方法
 * 3-4
 * 加个普通方法发现和同步锁无关
 * 换成两个对象后，不是同一把锁了，情况立刻变化。
 *
 */
public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        // 1
        new Thread(phone1::sendEmail, "a").start();
        new Thread(phone1::sendSMS, "b").start();

        //2
//        phone1.sendEmail();
//        Phone phone2 = new Phone();
    }
}


class Phone // 资源类
{
    public synchronized void sendEmail() {
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("----------sendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("----------sendSMS");
    }

    public void hello() {
        System.out.println("----hello----");
    }
}
