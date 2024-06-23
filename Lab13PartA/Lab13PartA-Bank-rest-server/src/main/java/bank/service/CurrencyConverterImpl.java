package bank.service;
import bank.service.CurrencyConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("currencyConverter")
public class CurrencyConverterImpl implements CurrencyConverter {

    Logger logger = LoggerFactory.getLogger(CurrencyConverterImpl.class);

    @Override
    public double euroToDollars(double amount) {
        logger.info("CurrencyConverter: converting {} dollars to euros", amount);
        return 1.57 * amount;
    }

    @Override
    public double dollarsToEuros(double amount) {
        return 0.637 * amount;
    }
}

