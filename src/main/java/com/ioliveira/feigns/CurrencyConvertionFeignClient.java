package com.ioliveira.feigns;

import com.ioliveira.beans.CurrencyConvertion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyConvertionFeignClient {

    //Mapeamento do controller CurrencyExchangeController
    @GetMapping(path = "/exchange/{from}/{to}")
    public CurrencyConvertion getExchangeValue(@PathVariable String from, @PathVariable String to);

}
