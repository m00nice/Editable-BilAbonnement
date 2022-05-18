package com.example.bilabonnement.controller;

import com.example.bilabonnement.models.Personale;
import com.example.bilabonnement.service.PersonaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class PersonaleController {

    private final PersonaleService personaleService = new PersonaleService();

    @GetMapping("/LogIn")
    public String index(){return "index";}

    @PostMapping("/LogIn")
    public String LogInd(@ModelAttribute(name="personale") Personale personale, Model model) throws SQLException {
        String brugernavn = personale.getBrugernavn();
        String password = personale.getPassword();
        model.addAttribute(brugernavn, password);
        boolean token = personaleService.checkBruger(brugernavn, password);
        if(token){
            String rolle = personaleService.getRolle(brugernavn, password);
            if(rolle.equals("DR")){return "redirect:Dataregistrering";}
            if(rolle.equals("FU")){return "redirect:Forretningsudviklere";}
            if(rolle.equals("S&U")){return "redirect:Skade&Udbedring";}
        }
        return "index";

        }


    //TODO method til at logge ud af system

    @PostMapping("/Dataregistrering")
    public String LogUd(){

        return "Dataregistrering";
    }


    }
