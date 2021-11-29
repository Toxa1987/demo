package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class GreetingController {
private GreetingClient client;

    public GreetingController(GreetingClient client) {
        this.client = client;
    }

    @GetMapping
public Mono<String> hello (){
    return client.getMessage();
}
}
