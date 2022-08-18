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
 * 3、添加一个普通方法hello，请问先打印邮箱还是hello
 * 4、有两部手机，先打印邮件还是短信
 * 5、两个静态同步方法，1部手机，请问先打印邮件还是短信
 * 6、两个静态同步方法，2部手机，请问先打印邮件还是短信
 * 7、有1个静态同步方法，有1个普通同步方法，有1部手机，请问先打印邮箱还是短信
 * 8、有1个静态同步方法，有一个普通同步方法，有两部手机，先打印邮箱还是短信
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


class Phone {
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
}
