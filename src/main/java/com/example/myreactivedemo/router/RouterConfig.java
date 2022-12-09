package com.example.myreactivedemo.router;

import com.example.myreactivedemo.dto.Stock;
import com.example.myreactivedemo.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {
    @Autowired
    private CustomerStreamHandler customerStreamHandler;
    private Stock getQuote;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/router/customers", customerStreamHandler::getCustomers)
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> getLtp()  {
        return RouterFunctions.route()
                .GET("/getQuote", customerStreamHandler::getQuotes)
                .build();
    }
}


