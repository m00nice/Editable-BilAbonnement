package com.example.bilabonnement.repository;
// Forfatter @Martin Anberg
import com.example.bilabonnement.models.Personale;
import utility.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaleRepository {


    public List<Personale> getAlleBrugere(){
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Personale> alleBrugere = new ArrayList<Personale>();
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM personale");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Personale temp = new Personale(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)
                );
                alleBrugere.add(temp);
            }
        } catch (SQLException throwable) {
            System.out.println("Noget er gået galt i getAlleBrugere");
            throwable.printStackTrace();
        }
        return alleBrugere;
    }

    public void executeSQLsyntax(String syntax){
        Connection conn = DatabaseConnectionManager.getConnection();
        try {
            conn.prepareStatement(syntax).execute();
        } catch (SQLException throwable) {
            System.out.println("Noget gik galt i executeSQLsyntax");
            throwable.printStackTrace();
        }
    }

}
