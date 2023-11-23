package bj.ine.guide.services;

import bj.ine.guide.domain.Product;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Log
@Service
public class CartService {
    private Map<Product, Integer> cart;

    private PaymentService paymentService;

    public CartService(PaymentService paymentService) {
        this.cart = new HashMap<>();
        this.paymentService = paymentService;
    }

    public void addProduct(Product product, int quantity) {
        cart.put(product, quantity);
    }

    public void payment(String accountNumber) {
        int amount = 0;

        Iterator<Map.Entry<Product, Integer>> iterator = cart.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Product, Integer> entry = iterator.next();
            amount += entry.getKey().getPrice() * entry.getValue();
        }

        paymentService.debit(accountNumber, amount);
    }
}
