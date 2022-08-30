package com.yao.lock.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @date: 2022/8/30
 * @author: yao
 */
public class ListUnSafeDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // 向集合中添加内容
                list.add(UUID.randomUUID().toString().substring(0, 8));
                // 从集合中获取内容
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}

class ListSource {
    List<String> list = new ArrayList<>();

    public void addList() {
        list.add(UUID.randomUUID().toString().substring(0, 8));
    }
}
