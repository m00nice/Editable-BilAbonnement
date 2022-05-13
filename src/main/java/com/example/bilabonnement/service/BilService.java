package com.example.bilabonnement.service;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.repository.BilRepository;
import java.util.List;

public class BilService {

    BilRepository bilRepository = new BilRepository();

    public List getAlleBiler(){
        return bilRepository.getAlleBiler();
    }

    public List getUdlejedeBiler(List<Bil>biler){
        List<Bil> udlejedeBiler = null;
        while (biler.iterator().hasNext()){
            if (biler.iterator().next().getKundeID() > 0){
                udlejedeBiler.add(biler.iterator().next());
            }
        }
        for (Bil bil : udlejedeBiler){
            System.out.println(bil.getPris());
        }
        return udlejedeBiler;
    }
}
