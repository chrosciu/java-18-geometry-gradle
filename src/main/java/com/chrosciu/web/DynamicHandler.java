package com.chrosciu.web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;

public class DynamicHandler implements HttpHandler {

    private static String POINT = """
        *
        """;

    private static String CIRCLE = """             
            ***
           *   *
          *     *
          *     *
          *     *
           *   *
            ***
        """;

    private static String SECTION = """
        *
         *
          *
        """;

    private static String TRIANGLE = """
           *
          * *
         *****
        """;

    private static String DEFAULT = """
        XXXX
        """;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        var requestPath = exchange.getRequestURI().getPath();
        var response = getResponse(requestPath);
        ServerUtils.sendStringResponseBody(exchange, response);
    }

    private String getResponse(String requestPath) {
        return switch (requestPath) {
            case String s && s.contains("section") -> SECTION;
            case String s && s.contains("circle") -> CIRCLE;
            case String s && s.contains("point") -> POINT;
            case String s && s.contains("triangle") -> TRIANGLE;
            default -> DEFAULT;
        };
    }
}
