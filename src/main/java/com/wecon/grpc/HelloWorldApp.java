package com.wecon.grpc;

import java.io.IOException;

/**
 * @author zhl
 * @create 2021/1/28 13:54
 * @description
 */
public class HelloWorldApp {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        GrpcServer server = new GrpcServer(port);
        server.start();
        GrpcClient client = new GrpcClient("localhost",port);
        String reply = client.sayHello("Jack");
        System.out.println(reply);
        server.shutdown();
    }
}
