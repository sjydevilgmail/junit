package hello;

import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class MyHandler implements Handler<RoutingContext> {
    @Override
    public void handle(RoutingContext event) {
        HttpServerRequest request = event.request();
        Buffer body = event.getBody();
        HttpServerResponse response = event.response();
        // Some code to test
        response.setStatusCode(200);
        response.end();
    }
};