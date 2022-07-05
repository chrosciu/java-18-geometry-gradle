package com.chrosciu.web;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServerUtils {
    public static Path getResourcePath(String resourcePathString) {
        ClassLoader classLoader = ServerUtils.class.getClassLoader();
        URL resourceUrl = classLoader.getResource(resourcePathString);
        String absoluteResourcePathString = resourceUrl.getFile();
        return Path.of(absoluteResourcePathString);
    }

    public static void sendStringResponseBody(HttpExchange httpExchange, String responseBody) {
        byte[] array = responseBody.getBytes();
        try {
            httpExchange.sendResponseHeaders(200, array.length);
            OutputStream writer = httpExchange.getResponseBody();
            writer.write(array);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
