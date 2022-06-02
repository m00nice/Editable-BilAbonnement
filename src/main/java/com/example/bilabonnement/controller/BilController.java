package com.example.bilabonnement.controller;
// Forfatter: @Martin Anberg, August Høg Dedenroth

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.service.BilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class BilController {
    private final BilService bilService = new BilService();


    @GetMapping("/SkadeOgUdbedring/Biler-med-skader")
     public String alleSkadetBiler(Model model) {
      ArrayList<Bil> skadeArrayList = bilService.getBilerMedFejlOgMangler();
      model.addAttribute("skadetBilListe", skadeArrayList);
      return "SkadeOgUdbedringSkadeListe";
 }

    @GetMapping("/SkadeOgUdbedring/Biler-uden-skader")
    public String alleBilerUdenSkade(Model model) {
        ArrayList<Bil> bilArrayList = bilService.getBilerUdenFejlOgMangler();
        model.addAttribute("uskadetBilListe", bilArrayList);
        return "SkadeOgUdbedringIkkeSkadeListe";
    }

    @PostMapping("/SkadeOgUdbedring/Biler-uden-skader")
    public String tilføjFejl(WebRequest fejlData){
        int bil_id = Integer.parseInt(fejlData.getParameter("bil_ID"));
        if(fejlData.getParameter("pris").equals("")){

            return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-uden-skader";
        }
        if (fejlData.getParameter("fejl").equals("")){

            return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-uden-skader";
        }
        if(!fejlData.getParameter("pris").equals("") && !fejlData.getParameter("fejl").equals("")){
            double pris = Double.parseDouble(fejlData.getParameter("pris"));
            String fejl = fejlData.getParameter("fejl");
            bilService.addFejl(bil_id,fejl,pris);
            return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-uden-skader";
        }
        return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-uden-skader";
    }
    @PostMapping("/SkadeOgUdbedring/Biler-med-skader")
    public String sletFejl(WebRequest fejlData){
        int bil_id = Integer.parseInt(fejlData.getParameter("bil_ID"));
        bilService.setFejlToNull(bil_id);

        return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-med-skader";
    }

    @GetMapping("/Forretningsudvikling")
    public String listeAfUdlejedeBiler(Model model){
        ArrayList<Bil> bilArrayList = bilService.getUdlejedeBiler();
        double totalpris = bilService.getTotalPrisPåUdlejedeBiler();
        model.addAttribute("billiste",bilArrayList);
        model.addAttribute("totalpris",totalpris);
        return "Forretningudviklere";
    }
}
