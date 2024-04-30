package org.example.provider;

import org.example.service.CurrencyConverter;

public class SEKPoundConverter implements CurrencyConverter {
    @Override
    public double convert(double amount, String fromCurrency) {
        if (fromCurrency.equals("SEK")) {
            return amount * 0.09;
        } else {
            return 0.0;
        }
    }

    @Override
    public String getTargetCurrency() {
        return "GBP";
    }
}