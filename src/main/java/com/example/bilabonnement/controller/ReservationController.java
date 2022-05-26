package com.example.bilabonnement.controller;

import com.example.bilabonnement.models.Reservation;
import com.example.bilabonnement.service.BilService;
import com.example.bilabonnement.service.KundeService;
import com.example.bilabonnement.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

// Forfatter @Martin Anberg
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
        return "DataregistreringValid";
    }
    @PostMapping("/Dataregistrering/Valid")
    public String ændreValidation1(WebRequest bilData){
        int reservationID = Integer.parseInt(bilData.getParameter("reservationID"));
        reservationService.ændreValidationReservation(reservationService.getReservation(reservationID));
        return "redirect:http://localhost:8080/Dataregistrering/Valid";
    }

    @GetMapping("/Dataregistrering/Invalid")
    public String visInvalidReservationer(Model model){
        ArrayList liste = reservationService.createInvalidReservationList();
        model.addAttribute("invalidliste",liste);
        return "DataregistreringInvalid";
    }

    @PostMapping("/Dataregistrering/Invalid")
    public String ændreValidation2(WebRequest bilData){
        int reservationID = Integer.parseInt(bilData.getParameter("reservationID"));
        reservationService.ændreValidationReservation(reservationService.getReservation(reservationID));
        return "redirect:http://localhost:8080/Dataregistrering/Invalid";
    }
    @PostMapping("/Dataregistrering/Invalid/DELETE")
    public String sletReservation(WebRequest bilData){
        int reservationID = Integer.parseInt(bilData.getParameter("reservationID"));
        reservationService.sletReservation(reservationID);
        return "redirect:http://localhost:8080/Dataregistrering/Invalid";
    }

    //TODO get method til at vise all info på reservation

    @GetMapping("/Dataregistrering/info")
    public String visReservationInfo(Reservation reservation, Model model1, Model model2){

        model1.addAttribute("bilTilInfo",bilService.getBil(reservation.getBilID()));
        model2.addAttribute("kundeInfo",kundeService.getKunde(reservation.getKundeID()));

        return "DataregistreringValid";

    }

}
