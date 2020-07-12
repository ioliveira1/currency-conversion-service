package com.ioliveira.converters;

import com.ioliveira.beans.CurrencyConversion;

import java.math.BigDecimal;

public class BeanConverter {

    public static CurrencyConversion convertCurrency(CurrencyConversion currencyConversion, String from, String to, Long quantity) {
        return currencyConversion.toBuilder()
                .from(from)
                .to(to)
                .quantity(quantity)
                .totalAmount(new BigDecimal(quantity * currencyConversion.getConversionMultiple()))
                .build();
    }

}
