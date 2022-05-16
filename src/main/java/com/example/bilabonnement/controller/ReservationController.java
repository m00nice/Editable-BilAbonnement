package com.example.bilabonnement.controller;

import com.example.bilabonnement.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {

    ReservationService reservationService = new ReservationService();

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
    public void ændreValidation(){
        int bilID = 1;
        int kundeID = 1;
        reservationService.ændreValidationReservation(reservationService.getReservation(bilID,kundeID));
    }

}
