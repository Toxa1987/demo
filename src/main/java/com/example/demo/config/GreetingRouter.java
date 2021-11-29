package com.example.demo.config;

import com.example.demo.Greeting;
import com.example.demo.GreetingClient;
import com.example.demo.GreetingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {
    private GreetingClient client;

    public GreetingRouter(GreetingClient client) {
        this.client = client;
    }

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions
                .route(GET("/hello")
                                .and(accept(MediaType.APPLICATION_JSON)),
                        greetingHandler::hello);
    }
    @Bean
    public RouterFunction<ServerResponse> route1() {
        return RouterFunctions
                .route(GET("/hell")
                                .and(accept(MediaType.APPLICATION_JSON)),
                        request -> ServerResponse.ok().body(BodyInserters.fromPublisher(client.getMessage(),String.class)));
    }

}
