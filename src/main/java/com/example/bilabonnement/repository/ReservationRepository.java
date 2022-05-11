package com.example.bilabonnement.repository;
// Forfatter @Martin Anberg
import com.example.bilabonnement.models.Personale;
import com.example.bilabonnement.models.Reservation;
import com.example.bilabonnement.service.BilService;
import utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {


    public List<Reservation> getAlleReservationer(){
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Reservation> alleReservation = new ArrayList<Reservation>();
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Reservation temp = new Reservation(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getBoolean(5)
                );
                alleReservation.add(temp);
            }
        } catch (SQLException throwable) {
            System.out.println("Noget er gået galt i getAlleReservation");
            throwable.printStackTrace();
        }
        return alleReservation;
    }
}
