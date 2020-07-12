package com.ioliveira.services;

import com.ioliveira.beans.CurrencyConversion;
import com.ioliveira.converters.BeanConverter;
import com.ioliveira.feigns.CurrencyConversionFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyConversionService {

    @Autowired
    private CurrencyConversionFeignClient feignClient;

    public CurrencyConversion convert(String from, String to, Long quantity) {

        //Chamada para o webservice currency-exchange-service
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("from", from);
        urlVariables.put("to", to);
        CurrencyConversion conversion = new RestTemplate()
                .getForEntity("http://localhost:8000/exchange/{from}/{to}", CurrencyConversion.class, urlVariables)
                .getBody();

        assert conversion != null;
        return BeanConverter.convertCurrency(conversion, from, to, quantity);
    }

    public CurrencyConversion convertFeign(String from, String to, Long quantity) {
        CurrencyConversion exchangeValue = feignClient.getExchangeValue(from, to);

        assert exchangeValue != null;
        return BeanConverter.convertCurrency(exchangeValue, from, to, quantity);
    }

}
