package com.example.bilabonnement;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.models.BilBuilder;
import com.example.bilabonnement.repository.BilRepository;
import com.example.bilabonnement.service.BilService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BilAbonnementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilAbonnementApplication.class, args);
        BilService bilService = new BilService();

        //bilService.createBil(new BilBuilder().setModel("BBB").buildBil());

        //bilService.deleteBil(16);
        bilService.updateBil(15);

        for (Bil bil : bilService.readBil()){
            System.out.println(bil);
        }
    }
}
