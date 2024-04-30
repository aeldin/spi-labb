import org.example.service.CurrencyConverter;

module org.example.consumer {
    requires org.example.service;
    uses org.example.service.CurrencyConverter;
}