package com.chrosciu.web;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import java.net.InetSocketAddress;
import lombok.SneakyThrows;

public class DualServer {

    @SneakyThrows
    public static void main(String[] args) {
        var dynamicHandler = new DynamicHandler();
        var staticHandler = SimpleFileServer.createFileHandler(ServerUtils.getResourcePath("static"));
        var server = HttpServer.create(
            new InetSocketAddress(8080), 0, "/", dynamicHandler);
        server.createContext("/static", staticHandler);
        server.start();

        System.out.println("Server started");
        for(;;) {}
    }
}
