package com.yao.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author lijun
 * @Date 2024/9/11 11:25
 */
public class Client {
    public static void main(String[] args) {
        final String DEFAULT_SERVER_HOST = "127.0.0.1";
        final int DEFAULT_SERVER_PORT = 8888;
        // 创建socket
        try (Socket socket = new Socket(DEFAULT_SERVER_HOST, DEFAULT_SERVER_PORT)) {
            // 接收消息
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //发送消息
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // 获取到用户输入信息
            BufferedReader userReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while (true) {
                String input = userReader.readLine();
                writer.write(input + "\n");
                writer.flush();
                msg = reader.readLine();
                System.out.println(msg);
                // 如果客户端输入quit就跳出循环
                if ("quit".equals(input)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
