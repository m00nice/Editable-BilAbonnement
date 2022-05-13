package com.example.bilabonnement;

import com.example.bilabonnement.service.BilService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BilAbonnementApplication {

    public static void main(String[] args) {
        BilService bilService = new BilService();
        SpringApplication.run(BilAbonnementApplication.class, args);
        System.out.println(bilService.getUdlejedeBiler(bilService.getAlleBiler()));
        System.out.println(bilService.getBilerMedFejl(bilService.getAlleBiler()));

    }

}
