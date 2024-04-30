package org.example.consumer;

import org.example.service.CurrencyConverter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<CurrencyConverter> loader = ServiceLoader.load(CurrencyConverter.class);
        Map<Integer, CurrencyConverter> converterMap = new HashMap<>();
        int menuIndex = 1;

        for (CurrencyConverter converter : loader) {
            System.out.println(menuIndex + ". " + converter.getClass().getSimpleName());
            converterMap.put(menuIndex, converter);
            menuIndex++;
        }

        if (converterMap.isEmpty()) {
            System.out.println("No CurrencyConverter implementations found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        CurrencyConverter selectedConverter = converterMap.get(choice);
        if (selectedConverter != null) {
            System.out.print("Enter amount in SEK: ");
            double amountSEK = scanner.nextDouble();
            double convertedAmount = selectedConverter.convert(amountSEK, "SEK");
            String targetCurrency = selectedConverter.getTargetCurrency();
            System.out.println("Amount converted: " + convertedAmount + " " + targetCurrency);
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
