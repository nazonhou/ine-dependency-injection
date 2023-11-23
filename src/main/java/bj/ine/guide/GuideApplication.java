package bj.ine.guide;

import bj.ine.guide.domain.Product;
import bj.ine.guide.services.*;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log
public class GuideApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuideApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CartService cartService) {
        return args -> {
            cartService.addProduct(
                    new Product("IPHONEX", 2_000_000),
                    4
            );
            cartService.addProduct(
                    new Product("HP ELITE BOOK", 700_000),
                    1
            );
            cartService.payment("0000000001");
        };
    }
}
