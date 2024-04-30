import org.example.provider.SEKDollarConverter;

module org.example.provider {
    requires org.example.service;
    provides org.example.service.CurrencyConverter with org.example.provider.SEKDollarConverter, org.example.provider.SEKEuroConverter;
}

