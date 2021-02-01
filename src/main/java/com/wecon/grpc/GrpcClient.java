package com.wecon.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author zhl
 * @create 2021/1/28 13:46
 * @description
 */
public class GrpcClient {

    private final HelloWorldGrpc.HelloWorldBlockingStub blockingStub;

    public GrpcClient(String host, int port){
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext()
                .build();
        blockingStub = HelloWorldGrpc.newBlockingStub(managedChannel);;
    }

    public String sayHello(String name){
        Greeting greeting = Greeting.newBuilder()
                .setName(name)
                .build();
        HelloResp resp = blockingStub.sayHello(greeting);
        return resp.getReply();
    }
}
