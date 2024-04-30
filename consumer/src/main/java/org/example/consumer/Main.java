package org.example.consumer;

import org.example.service.CurrencyConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<CurrencyConverter> loader = ServiceLoader.load(CurrencyConverter.class);
        Map<String, CurrencyConverter> converterMap = new HashMap<>();

        for (CurrencyConverter converter : loader) {
            converterMap.put(converter.getClass().getSimpleName(), converter);
        }

        System.out.println("Choose the conversion:");
        System.out.println("1. SEK to USD");
        System.out.println("2. SEK to EUR");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            CurrencyConverter selectedConverter = converterMap.get("SEKDollarConverter");
            if (selectedConverter != null) {
                System.out.print("Enter amount in SEK: ");
                double amountSEK = scanner.nextDouble();
                double amountUSD = selectedConverter.convert(amountSEK, "SEK", "USD");
                System.out.println("Amount in USD: " + amountUSD);
            } else {
                System.out.println("SEKDollarConverter implementation not found.");
            }
        } else if (choice == 2) {
            CurrencyConverter selectedConverter = converterMap.get("SEKEuroConverter");
            if (selectedConverter != null) {
                System.out.print("Enter amount in SEK: ");
                double amountSEK = scanner.nextDouble();
                double amountEUR = selectedConverter.convert(amountSEK, "SEK", "EUR");
                System.out.println("Amount in EUR: " + amountEUR);
            } else {
                System.out.println("SEKEuroConverter implementation not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
