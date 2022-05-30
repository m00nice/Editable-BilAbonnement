package com.example.bilabonnement.test;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.testService.TestService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Biltest {

    @Test
    void erPrisOverGennemsnit() {

        //Arrange
        TestService testService = new TestService();

        //Act
        Bil bil = new Bil(2011, "Skoda", "Citigo", "Hvid", 1, 1, 21000, "null", 0);
        boolean forventet = true;

        //Assert
        boolean resultat = testService.erPrisOverGennemsnit(bil);
        assertEquals(forventet, resultat);

    }

    @Test
    void getTotalPrisPåUdlejedeBiler() { //  til forretningudviklere

        //Arrange
        TestService testService = new TestService();

        //Act
        testService.getTotalPrisPåUdlejedeBiler();
        double forventet = 4;


        //Assert
        double resultat = testService.getTotalPrisPåUdlejedeBiler();
        assertEquals(forventet, resultat);

    }

    @Test
    void getUdlejedeBiler() {

        //Arrange
        TestService testService = new TestService();

        //Act
        testService.getUdlejedeBiler();
        int forventet = 3; // size på ArrayList i BilTestRepository

        //Assert
        int resultat = testService.getUdlejedeBiler().size();
        assertEquals(forventet,resultat);

    }
}



