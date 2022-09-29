package com.yao.net.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @date: 2022/9/29
 * @author: yao
 */
public class NetDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("网络名称");
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
    }
}
