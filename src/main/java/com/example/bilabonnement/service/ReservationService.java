package com.example.bilabonnement.service;

import com.example.bilabonnement.models.Reservation;
import com.example.bilabonnement.repository.ReservationRepository;

import java.util.ArrayList;

// Forfatter @Martin Anberg
public class ReservationService {

    private final ReservationRepository reservationRepository = new ReservationRepository();



    public Reservation getReservation(int reservationID){
        ArrayList<Reservation> alleReservationer = (ArrayList<Reservation>) reservationRepository.getAlleReservationer();
        for (Reservation reservation: alleReservationer) {
            if(reservation.getReservationID() == reservationID){
                return reservation;
            }
        }
        return null;
   }

   public ArrayList<Reservation> getAllreservations(){
        return (ArrayList<Reservation>) reservationRepository.getAlleReservationer();
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
        if(reservation.isValid()){reservation.setValid(false); reservationRepository.executeSQLSyntax("UPDATE `bilerfirm`.`reservation` SET `valid` = '-2' WHERE (`reservationID` = '"+reservation.getReservationID()+"')");}
        else{reservation.setValid(true); reservationRepository.executeSQLSyntax("UPDATE `bilerfirm`.`reservation` SET `valid` = '2' WHERE (`reservationID` = '"+reservation.getReservationID()+"')");}
    }
    public void sletReservation(int reservationID){
        reservationRepository.executeSQLSyntax("DELETE FROM `bilerfirm`.`reservation` WHERE (`reservationID` = '"+reservationID+"');");
    }
}
