package com.example.myreactivedemo.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import javax.xml.transform.Result;

@Component
@RequiredArgsConstructor
public class Stock {
    private final WebClient http;
    public Flux<Root> getStocks() {
        return this.http.get().uri("http://localhost/quote/INFY")
                .retrieve()
                .bodyToFlux(Root.class);
    }
}