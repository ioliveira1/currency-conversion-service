package com.ioliveira.feigns;

import com.ioliveira.beans.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyConversionFeignClient {

    //Mapeamento do controller CurrencyExchangeController
    @GetMapping(path = "currency-exchange-service/exchange/{from}/{to}")
    public CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to);

}
