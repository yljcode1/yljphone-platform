package com.yao.net.demo;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @date: 2022/9/29
 * @author: yao
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {

        // 找码头
        DatagramSocket datagramSocket = new DatagramSocket();
        // 打包礼物
        String s = "礼物";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10000;
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, port);

        // 码头发送包裹
        datagramSocket.send(datagramPacket);

        // 付钱走人
        datagramSocket.close();
    }
}
