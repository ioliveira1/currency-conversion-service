package com.ioliveira.beans;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class CurrencyConvertion {
    private Long id;
    private String from;
    private String to;
    private int conversionMultiple;
    private Long quantity;
    private BigDecimal totalAmount;
    private int port;
}
