package com.example.bilabonnement.service;
// Forfatter @Martin Anberg
import com.example.bilabonnement.models.Reservation;
import com.example.bilabonnement.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    private final ReservationRepository reservationRepository = new ReservationRepository();


    public Reservation getReservation(int bilID, int kundeID){
        ArrayList<Reservation> alleReservationer = (ArrayList<Reservation>) reservationRepository.getAlleReservationer();
        for (Reservation reservation: alleReservationer) {
            if(reservation.getBilID() == bilID && reservation.getKundeID() == kundeID){
                return reservation;
            }
        }
        return null;
   }



    public ArrayList createValidReservationList(){
         ArrayList<Reservation> alleReservationer = (ArrayList<Reservation>) reservationRepository.getAlleReservationer();
        ArrayList<Reservation> reservationer = new ArrayList();
        for (Reservation reservation: alleReservationer) {
            if(reservation.isValid()){
                reservationer.add(reservation);
            }
        }
        return reservationer;
    }


    public ArrayList createInvalidReservationList(){
        ArrayList<Reservation> alleReservationer = (ArrayList<Reservation>) reservationRepository.getAlleReservationer();
        ArrayList<Reservation> reservationer = new ArrayList();
        for (Reservation reservation: alleReservationer) {
            if(!reservation.isValid()){
                reservationer.add(reservation);
            }
        }
    return reservationer;
    }


    public void ændreValidationReservation(Reservation reservation){
        if(reservation.isValid()){reservation.setValid(false); reservationRepository.executeSQLsyntax("UPDATE `Bilabonnement`.`reservation` SET `valid` = '-2' WHERE (`bilID` = '"+reservation.getBilID()+"')");}
        else{reservation.setValid(true); reservationRepository.executeSQLsyntax("UPDATE `Bilabonnement`.`reservation` SET `valid` = '2' WHERE (`bilID` = '"+reservation.getBilID()+"')");}
    }

}
