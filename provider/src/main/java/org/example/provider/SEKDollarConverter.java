package org.example.provider;
import org.example.service.CurrencyConverter;

public class SEKDollarConverter implements org.example.service.CurrencyConverter {
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals("SEK") && toCurrency.equals("USD")) {
            return amount * 0.11;
        } else {
            // Handle other currency conversions if needed
            return 0.0;
        }
    }
}


