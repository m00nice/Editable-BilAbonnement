package com.example.bilabonnement.controller;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.service.BilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

@Controller
public class BilController {
    private final BilService bilService = new BilService();

    //TODO get method til at lave liste af biler med skade
    @GetMapping("/Skade&Udebedring/Biler-med-skader")
     public String alleSkadetBiler(@ModelAttribute (name = "skadeListe") Model model) {
      ArrayList<Bil> skadeArrayList = bilService.getBilerMedFejlOgMangler();
      model.addAttribute("skadeListe", skadeArrayList);
      return "Skade&Udbedring";
 }


    //TODO get method til at lave liste af biler uden skade

    @GetMapping("/Skade&Udbedring/Biler-uden-skader")
    public String alleBilerUdenSkade(@ModelAttribute(name= "skadeListe") Model model) {
        ArrayList<Bil> bilArrayList = bilService.getBilerUdenFejlOgMangler();
        model.addAttribute("skadeListe", bilArrayList);
        return "Skade&Udbedring";
    }

}
