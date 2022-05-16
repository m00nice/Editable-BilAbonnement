package com.example.bilabonnement.repository;
//Forfatter @Cem Akay Türker, Tobias Winkel
import com.example.bilabonnement.models.Kunde;
import utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KundeRepository {

    private ArrayList<Kunde> alleKunder = new ArrayList<>();

    public void createKunde(Kunde kunde) {
        String SQL_INSERT = "INSERT INTO kunde (fornavn,efternavn,adresse,postnummer,by,email,mobil,cpr_nr) VALUES (?,?,?,?,?,?,?,?)";
        try{
            Connection conn = DatabaseConnectionManager.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, kunde.getForNavn());
            preparedStatement.setString(2,kunde.getEfterNavn());
            preparedStatement.setString(3,kunde.getAdresse());
            preparedStatement.setInt(4,kunde.getPostNummer());
            preparedStatement.setString(5,kunde.getBy());
            preparedStatement.setString(6,kunde.getEmail());
            preparedStatement.setInt(7,kunde.getMobil());
            preparedStatement.setInt(8,kunde.getCpr_nr());

            int row = preparedStatement.executeUpdate();

        }catch(SQLException e){
            System.out.println("Cannot connect to database");
            e.printStackTrace();
        }
    }
    public ArrayList<Kunde> getAllUsers(){
        return alleKunder;
    }

    public List<Kunde> getAlleKunder(){
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Kunde> alleKunder = new ArrayList<Kunde>();
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Kunde temp = new Kunde(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
                alleKunder.add(temp);
            }
        } catch (SQLException throwable) {
            System.out.println("Noget er gået galt i getAlleKunder");
            throwable.printStackTrace();
        }
        return alleKunder;
    }

    public void executeSQLsyntax(String syntax){
        Connection conn = DatabaseConnectionManager.getConnection();
        try {
            conn.prepareStatement(syntax).execute();
        } catch (SQLException throwable) {
            System.out.println("Noget gik galt i executeSQLsyntax");

        }
    }

}
