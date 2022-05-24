package com.example.bilabonnement.controller;

import com.example.bilabonnement.models.Personale;
import com.example.bilabonnement.service.PersonaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;

@Controller
public class PersonaleController {

    private final PersonaleService personaleService = new PersonaleService();

    @GetMapping("/")
    public String index(){return "index";}

    @PostMapping("/")
    public String logInd(WebRequest personaleData) {
        String brugernavn = personaleData.getParameter("brugernavn");
        String password = personaleData.getParameter("password");
        boolean token = personaleService.checkBruger(brugernavn, password);
        if(token) {
            String rolle = personaleService.getRolle(brugernavn, password);
            if(rolle.equals("DR")){return "redirect:/Dataregistrering/Invalid";}
            if(rolle.equals("FU")){return "redirect:Forretningsudvikling";}
            if(rolle.equals("S&U")){return "redirect:/Skade&Udebedring/Biler-med-skader";}
        }
        return "index";

        }


    //TODO method til at logge ud af system
    /*
    @PostMapping("/Dataregistrering/Invalid")
    public String logUdDataregistreringInvalid(){
        return "redirect:/";
    }

    @PostMapping("/Dataregistrering/Valid")
    public String logUdDataregistreringValid(){
        return "redirect:/";
    }
    @PostMapping("/Skade&Udebedring/Biler-med-skader")
    public String logUdDataregistreringSogUmedSkade(){
        return "redirect:/";
    }
    @PostMapping("/Skade&Udebedring/Biler-uden-skader")
    public String logUdDataregistreringSogUudenSkade(){
        return "redirect:/";
    }
    @PostMapping("/Forretningsudviklere")
    public String logUdForretningsudviklere(){
        return "redirect:/";
    }
    */

    }
