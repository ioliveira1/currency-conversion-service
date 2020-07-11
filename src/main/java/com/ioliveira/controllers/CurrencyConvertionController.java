package com.ioliveira.controllers;

import com.ioliveira.beans.CurrencyConvertion;
import com.ioliveira.services.CurrencyConvertionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/convertion")
public class CurrencyConvertionController {

    @Autowired
    private CurrencyConvertionService service;

    @GetMapping(path = "/{from}/{to}/{quantity}")
    public ResponseEntity<CurrencyConvertion> currencyConvertion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable Long quantity) {

        return ResponseEntity.ok(service.convert(from, to, quantity));
    }

    @GetMapping(path = "/feign/{from}/{to}/{quantity}")
    public ResponseEntity<CurrencyConvertion> currencyConvertionFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable Long quantity) {

        return ResponseEntity.ok(service.convertFeign(from, to, quantity));
    }

}
