package com.yao.lock.demo;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
 * 5-6 都换成静态同步方法后，情况又变化
 * 三种synchronized锁的内容有一些差别：
 * 对于静态同步方法，锁的是当前类的class对象，如Phone，class唯一的一个模块
 * 对于同步方法块，锁的是synchronized括号内的对象
 * 7-8
 * 当一个线程试图访问同步代码块它首先必须得到锁，正常退出或者抛出异常的时候必须释放锁。
 * <p>
 * 所有的普通方法用的都是同一把锁-示例对象本身，就是new出来的具体示例对象本身，本类this
 * 也就是说如果一个实例对象普通同步方法获取锁后，该实例对象的其他普通同步方法必须等待获取锁的方法释放锁之后才能获取到锁，
 * <p>
 * 所有的静态同步方法用的也是同一把锁-类对象本身，就是我们说过的唯一模板Class
 * 具体实例对象this和唯一模板Class，这两把锁是不同的两个对象，所有静态方法与普通同步方法之间是不会有竞态条件的。
 * 但是一旦一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取锁。
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
        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 12.10));
        pairArrayList.add(new Pair<>("version", 12.19));
        pairArrayList.add(new Pair<>("version", 6.28));
// 生成的 map 集合中只有一个键值对：{version=6.28}
        Map<String, Double> map = pairArrayList.stream()
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
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
