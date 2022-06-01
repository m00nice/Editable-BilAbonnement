package com.example.bilabonnement.repository;
//Forfatter @Cem Akay Türker, Tobias Winkel
import com.example.bilabonnement.models.Kunde;
import utility.DatabaseConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KundeRepository {


    public List<Kunde> getAlleKunder(){
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Kunde> alleKunder = new ArrayList<Kunde>();
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM kunde");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Kunde temp = new Kunde(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                );
                alleKunder.add(temp);
            }
        } catch (SQLException throwable) {
            System.out.println("Noget er gået galt i getAlleKunder");
            throwable.printStackTrace();
        }
        return alleKunder;
    }

    public void executeSQLsyntax(String syntax) {
        Connection conn = DatabaseConnectionManager.getConnection();
        try {
            conn.prepareStatement(syntax).execute();
        } catch (SQLException throwable) {
            System.out.println("Noget gik galt i executeSQLsyntax");
            throwable.printStackTrace();
        }
    }
}
