package com.ioliveira;

import com.ioliveira.beans.CurrencyConvertion;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyConvertionService {

    public CurrencyConvertion convert(String from, String to, Long quantity) {

        //Chamada para o webservice currency-exchange-service
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("from", from);
        urlVariables.put("to", to);
        CurrencyConvertion convertion = new RestTemplate()
                .getForEntity("http://localhost:8000/exchange/{from}/{to}", CurrencyConvertion.class, urlVariables)
                .getBody();

        assert convertion != null;
        return CurrencyConvertion.builder()
                .id(convertion.getId())
                .from(from)
                .to(to)
                .conversionMultiple(convertion.getConversionMultiple())
                .quantity(quantity)
                .totalAmount(new BigDecimal(quantity * convertion.getConversionMultiple()))
                .port(convertion.getPort())
                .build();
    }

}
