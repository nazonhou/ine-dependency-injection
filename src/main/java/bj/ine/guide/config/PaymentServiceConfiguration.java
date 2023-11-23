package bj.ine.guide.config;

import bj.ine.guide.services.MobileMoneyService;
import bj.ine.guide.services.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentServiceConfiguration {
    @Bean
    PaymentService paymentService() {
        return new MobileMoneyService();
    }
}
