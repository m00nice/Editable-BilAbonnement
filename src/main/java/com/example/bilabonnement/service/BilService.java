package com.example.bilabonnement.service;


import com.example.bilabonnement.repository.BilRepository;

import java.time.LocalDate;
import java.util.List;

public class BilService {

    BilRepository bilRepository;

    public List getAlleBiler(){
        return bilRepository.getAlleBiler();
    }

}
