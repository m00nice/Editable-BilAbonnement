package com.example.bilabonnement.controller;
// Forfatter: @Martin Anberg, August Høg Dedenroth

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.service.BilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class BilController {
    private final BilService bilService = new BilService();


    //TODO get method til at lave liste af biler med skade
    @GetMapping("/SkadeOgUdebedring/Biler-med-skader")
     public String alleSkadetBiler(Model model) {
      ArrayList<Bil> skadeArrayList = bilService.getBilerMedFejlOgMangler();
      model.addAttribute("skadeListe", skadeArrayList);
      return "SkadeOgUdbedring";
 }

    //TODO get method til at lave liste af biler uden skade
    @GetMapping("/SkadeOgUdbedring/Biler-uden-skader")
    public String alleBilerUdenSkade(Model model) {
        ArrayList<Bil> bilArrayList = bilService.getBilerUdenFejlOgMangler();
        model.addAttribute("skadeListe", bilArrayList);
        return "SkadeOgUdbedring";
    }

    @GetMapping("/Forretningsudvikling")
    public String listeAfUdlejedeBiler(Model model){
        ArrayList<Bil> bilArrayList = bilService.getUdlejedeBiler();
        double totalpris = bilService.getTotalPrisPåUdlejedeBiler();
        model.addAttribute("billiste",bilArrayList);
        model.addAttribute("totalpris",totalpris);
        return "Forretningudviklere";
    }
    @PostMapping("/Forretningudvikling")
    public String tilføjFejl(WebRequest fejlData){
        String fejl = fejlData.getParameter("fejl");
        double pris = Double.parseDouble(fejlData.getParameter("pris"));
        int bil_id = Integer.parseInt(fejlData.getParameter("bil_ID"));
        bilService.setFejlID(bil_id,pris);

        return "Forretningudvikling";
    }

}
