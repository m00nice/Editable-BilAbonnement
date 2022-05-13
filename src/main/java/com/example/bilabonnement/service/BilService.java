package com.example.bilabonnement.service;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.repository.BilRepository;

import java.util.ArrayList;


public class BilService {

    BilRepository bilRepository = new BilRepository();

    public ArrayList getAlleBiler(){
        return (ArrayList) bilRepository.getAlleBiler();
    }

    public ArrayList getUdlejedeBiler(ArrayList<Bil>biler){
        ArrayList<Bil> udlejedeBiler = new ArrayList<>();
        for(Bil bil : biler){
            if (bil.getKundeID() > 0){
                udlejedeBiler.add(bil);
            }
        }
        for (Bil bil : udlejedeBiler){
            System.out.println(bil.getPris());
        }
        return udlejedeBiler;
    }
}
