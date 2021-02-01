package com.wecon.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author zhl
 * @create 2021/1/28 13:41
 * @description
 */
public class GrpcServer {
    private Server server;

    /**
     * 服务占用的端口
     * @param port
     */
    public GrpcServer(int port){
        server = ServerBuilder.forPort(port)
                //添加具体的实现
                .addService(new HelloWorldGrpcServiceImpl())
                .build();
    }

    public void start() throws IOException {
        server.start();
    }

    public void shutdown(){
        server.shutdown();
    }
}
