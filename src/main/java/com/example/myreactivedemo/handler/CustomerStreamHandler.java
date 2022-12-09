package com.example.myreactivedemo.handler;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.myreactivedemo.dto.Customer;
import com.example.myreactivedemo.dto.Ohlc;
import com.example.myreactivedemo.dto.Results;
import com.example.myreactivedemo.dto.Root;
import io.netty.handler.flush.FlushConsolidationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.PrivateKey;
import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerStreamHandler {
    private Ohlc ohlc;

    public Mono<ServerResponse> getCustomers(ServerRequest request){


       var thingToPass =  Flux.range(1,10)
               .delayElements(Duration.ofSeconds(1))
               .doOnNext(i -> System.out.println("Processing count :"+ i))
               .map((i -> new Customer(i , "customer"+i)));

        Flux<Customer> customerStream = thingToPass;

        return  ServerResponse.ok().
                contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerStream, Customer.class);

    }

    private final WebClient http;
    public Mono<ServerResponse> getQuotes(ServerRequest request){

        Flux<Root> latestLtp =  this.http.get().uri("http://localhost/quote/INFY")
                .retrieve()
                .bodyToFlux(Root.class);

//      Mono<String>  ohlcFlux = Mono.just("Pradnyil");
//        ohlcFlux =  latestLtp.map(s-> s.getResults().getOhlc());

        latestLtp.map(s-> s.getResults().getOhlc()).subscribe(System.out::println);
        latestLtp.map(s-> s.getResults().getDepth()).subscribe(System.out::println);
        latestLtp.map(s-> s.getResults()).subscribe(System.out::println);
        latestLtp.map(s-> s.getResults().instrument_token).subscribe(System.out::println);
//        ohlcFlux.subscribe(System.out::println);

        return  ServerResponse.ok()
                .body(latestLtp, Root.class);
    }

}
