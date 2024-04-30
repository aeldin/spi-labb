package org.example.provider;
import org.example.service.CurrencyConverter;

public class SEKEuroConverter implements org.example.service.CurrencyConverter {
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals("SEK") && toCurrency.equals("EUR")) {
            return amount * 0.09;
        } else {

            return 0.0;
        }
    }
}