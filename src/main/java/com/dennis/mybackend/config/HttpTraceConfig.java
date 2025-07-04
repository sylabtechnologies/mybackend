package com.dennis.mybackend.config;

import java.util.List;

import org.springframework.boot.actuate.web.exchanges.HttpExchange;
import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpTraceConfig {

    @Bean
    public HttpExchangeRepository httpTraceRepository() {
        // in-memory repo to store HTTP traces.
        // add management.endpoints.web.exposure.include=httpexchanges
    	
        var delegate = new InMemoryHttpExchangeRepository();
        
        return new HttpExchangeRepository() {
			
			@Override
			public List<HttpExchange> findAll() {
				return delegate.findAll();
			}
			
			@Override
			public void add(HttpExchange exchange) {
				String path = exchange.getRequest().getUri().getPath();
				if (!path.contains("actuator")) {
					delegate.add(exchange);
				}
				
			}
		};
        
        
        
    }
}