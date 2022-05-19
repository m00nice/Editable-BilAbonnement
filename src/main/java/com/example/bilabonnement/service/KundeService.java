package com.example.bilabonnement.service;

import com.example.bilabonnement.models.Kunde;
import com.example.bilabonnement.repository.KundeRepository;

import java.util.ArrayList;

public class KundeService {

    private final KundeRepository kundeRepository = new KundeRepository();

    public ArrayList<Kunde> getAlleKunder(){
        ArrayList<Kunde> kundeliste = (ArrayList<Kunde>) kundeRepository.getAlleKunder();
        return kundeliste;
    }

    public Kunde getKunde(int kundeID){
        ArrayList<Kunde> kundeliste = (ArrayList<Kunde>) kundeRepository.getAlleKunder();
        for (Kunde kunde: kundeliste) {
            if(kunde.getKundeID() == kundeID){
                return kunde;
            }
        }


        return null;
    }

}
