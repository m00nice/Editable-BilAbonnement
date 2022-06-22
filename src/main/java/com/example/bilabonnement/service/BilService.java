package com.example.bilabonnement.service;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.models.BilBuilder;
import com.example.bilabonnement.repository.BilRepository;

import java.util.ArrayList;

// Forfatter @Martin Anberg @Cemakay Türker
public class BilService {

    private final BilRepository bilRepository = new BilRepository();

    /* public ArrayList<Bil> getUdlejedeBiler(){
        ArrayList<Bil> biler = (ArrayList<Bil>) bilRepository.readAll();
        ArrayList<Bil> udlejedeBiler = new ArrayList<>();
        for(Bil bil : biler){
            if (bil.getKundeID() > 0 ){
                udlejedeBiler.add(bil);
            }
        }
        return udlejedeBiler;
    }*/
    /*public ArrayList<Bil> getBilerMedFejlOgMangler(){
        ArrayList<Bil> biler = (ArrayList<Bil>) bilRepository.readAll();
        ArrayList<Bil> bilMedFejl = new ArrayList<>();
        for (Bil bil : biler){
            if (bil.getKundeID() == 0 && bil.getFejl_pris() > 0){
                bilMedFejl.add(bil);
            }
        }
        return bilMedFejl;

    }*/
    /*
    public ArrayList<Bil> getBilerUdenFejlOgMangler(){
        ArrayList<Bil> biler = (ArrayList<Bil>) bilRepository.readAll();
        ArrayList<Bil> bilUdenFejl = new ArrayList<>();
        for (Bil bil : biler){
            if (bil.getFejl_pris() == 0 && bil.getKundeID() == 0){
                bilUdenFejl.add(bil);
            }
        }
        return bilUdenFejl;
    }*/

    public void setFejlToNull(int bil_ID){
        bilRepository.executeSQLsyntax("UPDATE `bilabonnement`.`bil` SET `fejl` = '', `fejl_pris` = '0' WHERE (`bil_ID` = '"+bil_ID+"');");
    }

    public void addFejl(int bil_ID, String fejl, double pris){
        bilRepository.executeSQLsyntax("UPDATE `bilabonnement`.`bil` SET `fejl` = '"+fejl+"', `fejl_pris` = '"+pris+"' WHERE (`bil_ID` = '"+bil_ID+"');");
    }
    /*
    public Bil getBil(int bilID){
        ArrayList<Bil> billiste = getAlleBiler();
        for (Bil bil:
            billiste) {
            if(bil.getBil_ID() == bilID){return bil;}
        }
        return null;
    }*/

   /* //Forfatter @Cem Akay Türker, August Høg Dedenroth
    public double getTotalPrisPåUdlejedeBiler(){
        ArrayList<Bil> bilArrayList = getUdlejedeBiler();
        double pris = 0;
        for (Bil bil : bilArrayList){
            if (bil.getKundeID() > 0) {
                pris += bil.getPris();
            }
        }
        return (Math.round(pris*100.0)/100.0);
    }*/
    //Forfatter @Cem Akay Türker
    public double getTotalPrisPåFejl(ArrayList<Bil> bilArrayList){
        double pris = 0;
        for (Bil bil : bilArrayList){
            if (bil.getFejl_pris() != 0){
               pris +=  bil.getFejl_pris();
            }
        }
        return pris;
    }
    public ArrayList<Bil> readBil(){
        return (ArrayList<Bil>) bilRepository.readAll();
    }
    public void createBil(Bil bil){
        this.bilRepository.create(bil);
    }

    public void updateBil(int id){
        this.bilRepository.update(id);
    }
    public void deleteBil(int id){
        this.bilRepository.delete(id);
    }


}
