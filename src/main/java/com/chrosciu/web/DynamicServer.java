package com.chrosciu.web;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import lombok.SneakyThrows;

public class DynamicServer {
    @SneakyThrows
    public static void main(String[] args) {
        var dynamicHandler = new DynamicHandler();
        var server = HttpServer.create(new InetSocketAddress(8080),
            0, "/", dynamicHandler);
        server.start();

        System.out.println("Server started");
        for(;;) {}
    }
}
