package com.example.bilabonnement.service;
// Forfatter @Martin Anberg

import com.example.bilabonnement.models.Personale;
import com.example.bilabonnement.repository.PersonalleRepository;

import java.util.List;

public class PersonalleService {
    PersonalleRepository personalleRepository;

    public boolean checkBruger(String brugernavn, String password) {
        List<Personale> list = personalleRepository.getAlleBrugere();
        while (list.iterator().hasNext()) {
            if (list.iterator().next().getBrugernavn().equals(brugernavn) || list.iterator().next().getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String getRolle(String brugernavn, String password) {
        List<Personale> list = personalleRepository.getAlleBrugere();
        while (list.iterator().hasNext()) {
            if (list.iterator().next().getBrugernavn().equals(brugernavn) || list.iterator().next().getPassword().equals(password)) {
                return list.iterator().next().getRolle();
            }
        }
        return "bruh";
    }
}
