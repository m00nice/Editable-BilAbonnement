package com.example.bilabonnement.service;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.repository.BilRepository;

import java.util.ArrayList;


public class BilService {

    BilRepository bilRepository = new BilRepository();

    public ArrayList<Bil> getAlleBiler(){
        return (ArrayList<Bil>) bilRepository.getAlleBiler();
    }

    public ArrayList<Bil> getUdlejedeBiler(ArrayList<Bil>biler){
        ArrayList<Bil> udlejedeBiler = new ArrayList<>();
        for(Bil bil : biler){
            if (bil.getKundeID() > 0 ){
                udlejedeBiler.add(bil);
            }
        }
        return udlejedeBiler;
    }

    public ArrayList<Bil> getBilerMedFejlOgMangler(ArrayList<Bil> biler){
        ArrayList<Bil> bilMedFejl = new ArrayList<>();
        for (Bil bil : biler){
            if (bil.getKundeID() == 0 && bil.getFejl_id() > 0){
                bilMedFejl.add(bil);
            }
        }
        return bilMedFejl;
    }

    public ArrayList<Bil> getBilerUdenFejlOgMangler(ArrayList<Bil> biler){
        ArrayList<Bil> bilUdenFejl = new ArrayList<>();
        for (Bil bil : biler){
            if (bil.getFejl_id() == 0){
                bilUdenFejl.add(bil);
            }
        }
        return bilUdenFejl;
    }

    public void setFejlIdToNull(Bil bil){
        bil.setFejl_id(0);
    }
    public void setFejlID(Bil bil, int fejl){
        bil.setFejl_id(fejl);
    }

    //Forfatter @Cem Akay Türker
    public double getTotalPrisPåUdlejedeBiler(ArrayList<Bil> bilArrayList){
        double pris = 0;
        for (Bil bil : bilArrayList){
            if (bil.getKundeID() > 0) {
                pris += bil.getPris();
            }
        }
        return pris;
    }
    //Forfatter @Cem Akay Türker
    public double getTotalPrisPåFejl(ArrayList<Bil> bilArrayList){
        double pris = 0;
        for (Bil bil : bilArrayList){
            if (bil.getFejl_id() != 0){
               pris +=  bil.getFejl_id();
            }
        }
        return pris;
    }
}
