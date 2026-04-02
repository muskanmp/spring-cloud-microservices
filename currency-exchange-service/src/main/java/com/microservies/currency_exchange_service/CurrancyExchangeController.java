package com.microservies.currency_exchange_service;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrancyExchangeController{

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrenyExchange (@PathVariable String from, @PathVariable String to){
        
        return new CurrencyExchange(100L, from, to, BigDecimal.valueOf(90));
    }
}