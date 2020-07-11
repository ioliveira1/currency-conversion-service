package com.ioliveira.converters;

import com.ioliveira.beans.CurrencyConvertion;

import java.math.BigDecimal;

public class BeanConverter {

    public static CurrencyConvertion convertCurrency(CurrencyConvertion currencyConvertion, String from, String to, Long quantity) {
        return currencyConvertion.toBuilder()
                .from(from)
                .to(to)
                .quantity(quantity)
                .totalAmount(new BigDecimal(quantity * currencyConvertion.getConversionMultiple()))
                .build();
    }

}
