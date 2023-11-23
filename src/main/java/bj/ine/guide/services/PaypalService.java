package bj.ine.guide.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Log
public class PaypalService implements PaymentService {
    private final Map<String, Integer> accounts;

    public PaypalService() {
        accounts = new HashMap<>();
        accounts.put("0000000001", 20_000_000);
        accounts.put("0000000002", 10_000);
        accounts.put("0000000003", 100_000);
        accounts.put("0000000004", 1_000_000);
    }

    public void debit(String accountNumber, int amount) {
        if (!accounts.containsKey(accountNumber)) {
            log.severe(
                    "accountNumber does not exists"
            );
            return;
        }

        if (accounts.get(accountNumber) < amount) {
            log.severe(
                    "balance is less than amount"
            );
            return;
        }

        accounts.put(accountNumber, accounts.get(accountNumber) - amount);

        log.info("Welcome to Paypal Service");
        log.info("Debit " + amount + " from " + accountNumber + " succeed");
        log.info("Your new balance is " + accounts.get(accountNumber));
    }
}
