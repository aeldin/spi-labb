package org.example.provider;

import org.example.service.CurrencyConverter;

public class SwedishGreeting implements CurrencyConverter {

    @Override
    public String greet(String name) {
        return "Hej " + name;
    }
}
