package com.example.bilabonnement.testRepository;

import com.example.bilabonnement.models.Bil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Forfatter @Cemakay Türker @August Høg Dedenroth @Tobias Winkel
public class BilTestRepository {
    public List<Bil> getAlleBiler() {
        ArrayList<Bil> bilArrayList = new ArrayList<>(
                Arrays.asList(
                        new Bil(2011, "Skoda", "Citigo", "Hvid", 1, 1, 11, "null", 0),
                        new Bil(2011, "Skoda", "Fabia", "Sort", 2, 2, 22, "null", 0),
                        new Bil(2011, "Skoda", "Octavia", "Sølv", 3, 3, 11, "null", 0)
                )
        );
        return bilArrayList;
    }


}

