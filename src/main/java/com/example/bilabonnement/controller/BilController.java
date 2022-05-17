package com.example.bilabonnement.controller;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.repository.BilRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.bilabonnement.repository.IRepository;

@Controller
public class BilController {
    private final IRepository<Bil> bilRepository = new BilRepository();

    //TODO get method til at lave liste af biler med skade
    @GetMapping("/listeAfSkadetBiler")
     public String alleSkadetBiler(Model model) {
      return "listeAfSkadetBiler";
 }


    //TODO get method til at lave liste af biler uden skade


}
