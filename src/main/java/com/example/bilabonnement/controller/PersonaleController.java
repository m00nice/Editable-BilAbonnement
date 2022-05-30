package com.example.bilabonnement.controller;

import com.example.bilabonnement.service.PersonaleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpSession;


@Controller
public class PersonaleController {

    private final PersonaleService personaleService = new PersonaleService();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String logInd(WebRequest personaleData,HttpSession session) {
        String brugernavn = personaleData.getParameter("brugernavn");
        String password = personaleData.getParameter("password");
        boolean token = personaleService.checkBruger(brugernavn, password);
        if (token) {
            String rolle = personaleService.getRolle(brugernavn, password);
            session.setAttribute("isloggedin", true);

            if (rolle.equals("DR")) {
                return "redirect:http://localhost:8080/Dataregistrering/Invalid";
            }
            if (rolle.equals("FU")) {
                return "redirect:http://localhost:8080/Forretningsudvikling";
            }
            if (rolle.equals("S&U")) {
                return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-med-skader";
            }
        }
        return "redirect:http://localhost:8080/";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("isloggedin");
        session.invalidate();
        return "redirect:/";
    }


 /*   //TODO method til at logge ud af system

    @PostMapping("/Dataregistrering/Invalid")
    public String logUdDataregistreringInvalid(){
        return "redirect:/";
    }*/

    /*
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
