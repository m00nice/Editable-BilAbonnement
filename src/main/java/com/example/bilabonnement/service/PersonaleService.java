package com.example.bilabonnement.service;
// Forfatter @Martin Anberg

import com.example.bilabonnement.models.Personale;
import com.example.bilabonnement.repository.PersonaleRepository;

import java.util.List;

public class PersonaleService {
    PersonaleRepository personaleRepository;

    public boolean checkBruger(String brugernavn, String password) {
        List<Personale> list = personaleRepository.getAlleBrugere();
        while (list.iterator().hasNext()) {
            if (list.iterator().next().getBrugernavn().equals(brugernavn) || list.iterator().next().getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String getRolle(String brugernavn, String password) {
        List<Personale> list = personaleRepository.getAlleBrugere();
        while (list.iterator().hasNext()) {
            if (list.iterator().next().getBrugernavn().equals(brugernavn) || list.iterator().next().getPassword().equals(password)) {
                return list.iterator().next().getRolle();
            }
        }
        return "bruh";
    }
}
