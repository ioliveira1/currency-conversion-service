package com.ioliveira.services;

import com.ioliveira.beans.CurrencyConvertion;
import com.ioliveira.converters.BeanConverter;
import com.ioliveira.feigns.CurrencyConvertionFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyConvertionService {

    @Autowired
    private CurrencyConvertionFeignClient feignClient;

    public CurrencyConvertion convert(String from, String to, Long quantity) {

        //Chamada para o webservice currency-exchange-service
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("from", from);
        urlVariables.put("to", to);
        CurrencyConvertion convertion = new RestTemplate()
                .getForEntity("http://localhost:8000/exchange/{from}/{to}", CurrencyConvertion.class, urlVariables)
                .getBody();

        assert convertion != null;
        return BeanConverter.convertCurrency(convertion, from, to, quantity);
    }

    public CurrencyConvertion convertFeign(String from, String to, Long quantity) {
        CurrencyConvertion exchangeValue = feignClient.getExchangeValue(from, to);

        assert exchangeValue != null;
        return BeanConverter.convertCurrency(exchangeValue, from, to, quantity);
    }

}
