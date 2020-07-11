package com.ioliveira.controllers;

import com.ioliveira.beans.CurrencyConvertion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/convertion")
public class CurrencyConvertionController {

    @GetMapping(path = "/{from}/{to}/{quantity}")
    public ResponseEntity<CurrencyConvertion> currencyConvertion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable Long quantity) {

        CurrencyConvertion currencyConvertion = CurrencyConvertion.builder()
                .id(10L)
                .from(from)
                .to(to)
                .conversionMultiple(65)
                .quantity(quantity)
                .totalAmount(new BigDecimal(200))
                .port(8080)
                .build();

        return ResponseEntity.ok(currencyConvertion);
    }

}
