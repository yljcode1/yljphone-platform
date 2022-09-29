package com.yao.net.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

/**
 * @date: 2022/9/29
 * @author: yao
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
//        DatagramChannel open = DatagramChannel.open();
//        InetAddress address = InetAddress.getByName("127.0.0.1");
//        DatagramSocket socket = open.socket();

        DatagramSocket datagramSocket = new DatagramSocket(10000);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data,0,datagramPacket.getLength()));
        datagramSocket.close();
    }
}
