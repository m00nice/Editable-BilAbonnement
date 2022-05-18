package com.example.bilabonnement.service;
// Forfatter @Martin Anberg

import com.example.bilabonnement.models.Personale;
import com.example.bilabonnement.repository.PersonaleRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonaleService {
    private final PersonaleRepository personaleRepository = new PersonaleRepository();

    public boolean checkBruger(String brugernavn, String password) {
        ArrayList<Personale> personalelist = (ArrayList<Personale>) personaleRepository.getAlleBrugere();
        for (Personale personale: personalelist) {
            if(personale.getBrugernavn().equals(brugernavn)&&personale.getPassword().equals(password)){return true;}
        }
        return false;
    }

    public String getRolle(String brugernavn, String password) {
        ArrayList<Personale> personalelist = (ArrayList<Personale>) personaleRepository.getAlleBrugere();
        for (Personale personale: personalelist) {
            if (personale.getBrugernavn().equals(brugernavn)&&personale.getPassword().equals(password)) {
                return personale.getRolle();
            }
        }
        return "bruh";
    }
}
