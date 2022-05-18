package com.example.bilabonnement.controller;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.repository.BilRepository;
import com.example.bilabonnement.service.BilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.bilabonnement.repository.IRepository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

@Controller
public class BilController {
    private final IRepository<Bil> bilRepository = new BilRepository();
    private final BilService bilService = new BilService();

    //TODO get method til at lave liste af biler med skade
    @GetMapping("/listeAfSkadetBiler")
     public String alleSkadetBiler(Model model) {
        model.addAttribute("listeAfSkadetBiler", bilRepository.getAlleSkadetBiler());
      return "listeAfSkadetBiler";
 }


    //TODO get method til at lave liste af biler uden skade

    @GetMapping("/getListeAfBilerUdenSkade")
    public String alleBilerUdenSkade(@ModelAttribute(name= "skadeListe") Model model){
        ArrayList<Bil> bilArrayList = bilService.getBilerUdenFejlOgMangler();
        model.addAttribute("skadeListe", bilArrayList);
        return "Skade&Udbedring";
    }

}
