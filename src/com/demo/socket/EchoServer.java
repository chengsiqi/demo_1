package com.demo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author csq
 * @date 2020/4/23 10:12
 * @description
 *
 * 使用Java的套接字编程实现一个多线程的回显(echo)服务器
 *
 * echo服务器，描述起来很简单，服务端收到什么，就给客户端发送什么。
 *
 * 基于TCP Socket编程，
 *  服务端主要是，创建socket、绑定IP和端口、监听、接受连接、处理数据包、关闭连接。
 *  客户端主要是，创建socket、连接到服务器、发送请求、关闭连接。
 **/
public class EchoServer {

    private static final int ECHO_SERVER_PORT = 6789;

    public static void main(String[] args){
        try (ServerSocket serverSocket = new ServerSocket(ECHO_SERVER_PORT)){
            System.out.println("服务器已经启动...");
            while (true){
                Socket client = serverSocket.accept();
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable{

        private Socket client;

        public ClientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter pw = new PrintWriter(client.getOutputStream())){
                String msg = br.readLine();
                System.out.println("收到" + client.getInetAddress() + "发送的：" + msg);
                pw.println(msg);
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 注意：上面的代码使用了Java7的TWR语法，由于很多外部资源类都间接的实现了AutoCloseable接口（单方法回调接口），
    // 因此可以利用TWR语法在try结束的时候通过回调的方式自动调用外部资源类的close()方法，避免书写冗长的finally代码块。
    // 此外，上面的代码用一个静态内部类实现线程的功能，使用多线程可以避免一个用户I/O操作所产生的中断影响其他用户对服务器的访问，
    // 简单的说就是一个用户的输入操作不会造成其他用户的阻塞。
    // 当然，上面的代码使用线程池可以获得更好的性能，因为频繁的创建和销毁线程所造成的开销也是不可忽视的。
}






















