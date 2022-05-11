package com.example.bilabonnement.repository;
// Forfatter @Martin Anberg
import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.models.Reservation;
import utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BilRepository {




    public List<Bil> getAlleBiler(){
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Bil> alleBiler = new ArrayList<Bil>();
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Bil temp = new Bil(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getDouble(7)
                );
                alleBiler.add(temp);
            }
        } catch (SQLException throwables) {
            System.out.println("Noget er gået galt i getAlleBiler");
            throwables.printStackTrace();
        }
        return alleBiler;
    }
}

