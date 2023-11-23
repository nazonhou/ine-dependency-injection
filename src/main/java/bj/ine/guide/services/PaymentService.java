package bj.ine.guide.services;

public interface PaymentService {
    public void debit(String accountNumber, int amount);
}
