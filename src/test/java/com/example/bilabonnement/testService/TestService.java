package com.example.bilabonnement.testService;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.testRepository.BilTestRepository;

import java.util.List;

public class TestService {

    BilTestRepository testRepository = new BilTestRepository();

    public double getTotalPrisPåUdlejedeBiler(){

        List<Bil> bilArrayList = testRepository.getAlleBiler();
        double pris = 0;
        for (Bil bil : bilArrayList){
            if (bil.getKundeID() > 0) {
                pris += bil.getPris();
            }
        }
        return (Math.round(pris*100.0)/100.0);
    }

    public boolean erPrisOverGennemsnit(Bil bil){
        List<Bil> bilListe = testRepository.getAlleBiler();
        int gennemsnit = 0;

        for (int i = 0; i < bilListe.size(); i++) {
            gennemsnit += bilListe.get(i).getPris();
        }
        gennemsnit = gennemsnit / bilListe.size();


        if (bil.getPris()>= gennemsnit){
            return true;
        } else {
            return false;
        }
    }


}
