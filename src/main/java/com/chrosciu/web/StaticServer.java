package com.chrosciu.web;

import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;
import java.net.InetSocketAddress;

public class StaticServer {

    public static void main(String[] args) {
        var server = SimpleFileServer.createFileServer(
            new InetSocketAddress(8080),
            ServerUtils.getResourcePath("static"),
            OutputLevel.VERBOSE);
        server.start();

        System.out.println("Server started");
        for(;;) {}
    }
}
