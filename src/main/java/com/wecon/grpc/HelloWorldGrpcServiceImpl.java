package com.wecon.grpc;

import io.grpc.stub.StreamObserver;

/**
 * @author zhl
 * @create 2021/1/28 11:43
 * @description
 */
public class HelloWorldGrpcServiceImpl extends HelloWorldGrpc.HelloWorldImplBase{
    public void sayHello(Greeting request, StreamObserver<HelloResp> respStreamObserver){
        String name = request.getName();
        HelloResp resp = HelloResp.newBuilder().setReply("Hello,"+name+"!").build();
        respStreamObserver.onNext(resp);
        respStreamObserver.onCompleted();
    }
}
