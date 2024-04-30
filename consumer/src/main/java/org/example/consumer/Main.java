package org.example.consumer;

import org.example.service.CurrencyConverter;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<CurrencyConverter> loader = ServiceLoader.load(CurrencyConverter.class);

        for (CurrencyConverter greeting : loader) {
            System.out.println(greeting.greet("Mika"));


        }

    }
}
