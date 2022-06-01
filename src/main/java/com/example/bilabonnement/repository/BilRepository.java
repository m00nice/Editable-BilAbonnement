package com.example.bilabonnement.repository;
// Forfatter @Martin Anberg
import com.example.bilabonnement.models.Bil;
import utility.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BilRepository{

    public List<Bil> getAlleBiler(){  // tager fat i databasen og returnerer listen
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Bil> alleBiler = new ArrayList<>();
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM bil");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){

                Bil temp = new Bil(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getString(8),
                        rs.getDouble(9)
                );
                alleBiler.add(temp);
            }
        } catch (SQLException throwable) {
            System.out.println("Noget er gået galt i getAlleBiler");
            throwable.printStackTrace();
        }
        return alleBiler;
    }

    public void executeSQLsyntax(String syntax) { // foretager ændringer på data i databasen
        Connection conn = DatabaseConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(syntax);
            preparedStatement.execute();
        } catch (SQLException throwable) {
            System.out.println("Noget gik galt i executeSQLsyntax");
            throwable.printStackTrace();
        }

    }
}
