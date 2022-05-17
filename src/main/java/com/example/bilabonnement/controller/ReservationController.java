package com.example.bilabonnement.controller;

import com.example.bilabonnement.models.Reservation;
import com.example.bilabonnement.repository.BilRepository;
import com.example.bilabonnement.service.BilService;
import com.example.bilabonnement.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {

    //TODO GENERELT tilføj SQL syntax til at ændre i databasen



    ReservationService reservationService = new ReservationService();
    BilService bilService = new BilService();

    @GetMapping("/Dataregistrering")
    public String ShowValidReservationer(){
        reservationService.createValidReservationList();

        return "Dataregistrering";
    }
    @GetMapping("/Dataregistrering")
    public String ShowInvalidReservationer(){
        reservationService.createInvalidReservationList();

        return "Dataregistrering";
    }
    @PostMapping("/Dataregistrering")
    public void ændreValidation(@ModelAttribute(name = "reservation") Reservation reservation, Model model){
        int bilID = reservation.getBilID();
        int kundeID = reservation.getKundeID();
        model.addAttribute("bilID",bilID);
        model.addAttribute("kundeID",kundeID);
        reservationService.ændreValidationReservation(reservationService.getReservation(bilID,kundeID));
    }

    //TODO get method til at vise all info på reservation

    @GetMapping("/Dataregistrering")
    public String showReservertionInfo(@ModelAttribute(name = "reservation") Reservation reservation){
        bilService.getBil(reservation.getBilID());


        reservation.getKundeID();
        return "Dataregistrering";
    }

}
