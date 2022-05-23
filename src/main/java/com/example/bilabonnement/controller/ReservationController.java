package com.example.bilabonnement.controller;

import com.example.bilabonnement.models.Reservation;
import com.example.bilabonnement.service.BilService;
import com.example.bilabonnement.service.KundeService;
import com.example.bilabonnement.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class ReservationController {

    //TODO GENERELT tilføj SQL syntax til at ændre i databasen


    private final ReservationService reservationService = new ReservationService();
    private final BilService bilService = new BilService();
    private final KundeService kundeService = new KundeService();

    @GetMapping("/Dataregistrering/Valid")
    public String visValidReservationer(Model model){
        ArrayList liste = reservationService.createValidReservationList();
        model.addAttribute("validliste",liste);
        return "/Dataregistrering";
    }
    @GetMapping("/Dataregistrering/Invalid")
    public String visInvalidReservationer(Model model){
        ArrayList liste = reservationService.createInvalidReservationList();
        model.addAttribute("invalidliste",liste);
        return "DataregistreringInvalid";
    }

    @PostMapping("/Dataregistrering/Invalid")
    public String ændreValidation(Reservation reservation, Model model){
        int bilID = reservation.getBilID();
        int kundeID = reservation.getKundeID();
        model.addAttribute("bilID",bilID);
        model.addAttribute("kundeID",kundeID);
        reservationService.ændreValidationReservation(reservationService.getReservation(bilID,kundeID));
        return "Dataregistrering";
    }

    @PostMapping("/Dataregistrering/")
    public String showData(Reservation reservation, Model model) {
        int bilID = reservation.getBilID();
        int kundeID = reservation.getKundeID();


        return "Dataregistrering";
    }
    //TODO get method til at vise all info på reservation

    @GetMapping("/Dataregistrering/info")
    public String visReservationInfo(Reservation reservation, Model model1, Model model2){


        model1.addAttribute("bil",bilService.getBil(reservation.getBilID()));
        model2.addAttribute("kunde",kundeService.getKunde(reservation.getKundeID()));

        return "Dataregistrering";
    }

}
