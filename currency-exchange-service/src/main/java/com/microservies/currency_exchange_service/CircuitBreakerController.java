package com.microservies.currency_exchange_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
// import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {
    
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/circuit-breaker-test")
    // @Retry(name="sample-test", fallbackMethod = "hardCodeResponse")
    // @CircuitBreaker(name="default", fallbackMethod = "hardCodeResponse")
    // @RateLimiter(name="default")
    @Bulkhead(name = "default")
    public String circuitBreakerTest(){
        logger.info("Sample API Called");
        // ResponseEntity<String> entity = new RestTemplate().getForEntity("localhost:8080/sample-url", String.class);
        // return entity.getBody();
        return "Sample API Response";
    }

    public String hardCodeResponse(Exception ex){
        return "Fall Back Response";
    }
}
