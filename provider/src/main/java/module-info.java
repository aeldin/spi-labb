import org.example.provider.SwedishGreeting;
import org.example.service.CurrencyConverter;

module org.example.provider.Greeting {
    requires org.example.service;

    provides CurrencyConverter with SwedishGreeting;
}