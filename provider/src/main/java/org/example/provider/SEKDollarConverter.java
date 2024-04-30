package org.example.provider;

import org.example.service.CurrencyConverter;

public class SEKDollarConverter implements CurrencyConverter {
    @Override
    public double convert(double amount, String fromCurrency) {
        if (fromCurrency.equals("SEK")) {
            return amount * 0.11; // Convert SEK to USD
        } else {
            return 0.0;
        }
    }

    @Override
    public String getTargetCurrency() {
        return "USD";
    }
}


