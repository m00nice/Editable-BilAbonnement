package com.example.bilabonnement.service;
// Forfatter @Martin Anberg @Cemakay Türker
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

    public ArrayList getBilerMedFejl(ArrayList<Bil> biler){
        ArrayList<Bil> bilMedFejl = new ArrayList<>();
        for (Bil bil : biler){
            if (bil.getKundeID() == 0 && bil.getPrisPåFejl() > 0){
                bilMedFejl.add(bil);
            }
        }
        for (Bil bil : bilMedFejl){
            System.out.println(bil.getPrisPåFejl());
        }
        return bilMedFejl;

    }

    public ArrayList getBilerUdenFejl(ArrayList<Bil> biler){
        ArrayList<Bil> bilUdenFejl = new ArrayList<>();
        for (Bil bil : biler){
            if (bil.getKundeID() == 0 && bil.getPrisPåFejl() == 0){
                bilUdenFejl.add(bil);
            }
        }
        for (Bil bil : bilUdenFejl){
            System.out.println(bil.getPrisPåFejl());
        }
        return bilUdenFejl;
    }

    public Bil getBil(int bilID){
        ArrayList<Bil> billiste = getAlleBiler();
        for (Bil bil:
            billiste) {
            if(bil.getBil_id() == bilID){return bil;}
        }
        return null;
    }



    public void setBilFejlOgMangelTilIntet(Bil bil){
        bil.setFejlOgMangler("");
        bil.setPrisPåFejl(0);
    }
    public void setBilFejlOgMangel(Bil bil, String Fejl, int Pris){
        bil.setFejlOgMangler(Fejl);
        bil.setPrisPåFejl(Pris);
    }
}
