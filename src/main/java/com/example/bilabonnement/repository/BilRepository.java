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

public class BilRepository implements IRepository<Bil> {
    Connection myConnection;
    PreparedStatement myPreparedStatement;
    ResultSet rs; // er et interface

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

    @Override
    public void create(Bil entity) { // Create i Crud
        try {

            myConnection = DatabaseConnectionManager.getConnection();

            myPreparedStatement = myConnection.prepareStatement("INSERT INTO bil(" + // sql statement
                    "årgang,mærke,model,farve,kundeID, pris, fejl, fejl_pris) VALUES (?,?,?,?,?,?,?,?)");
            myPreparedStatement.setInt(1, entity.getAargang()); // setMethods of PreparedStatement
            myPreparedStatement.setString(2, entity.getMaerke());
            myPreparedStatement.setString(3, entity.getModel());
            myPreparedStatement.setString(4, entity.getFarve());
            myPreparedStatement.setInt(5, entity.getKundeID());
            myPreparedStatement.setDouble(6, entity.getPris());
            myPreparedStatement.setString(7, entity.getFejl());
            myPreparedStatement.setDouble(8, entity.getFejl_pris());

            myPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bil> readAll() {  // Read i CRUD. Tager fat i databasen og returnerer listen
        myConnection = DatabaseConnectionManager.getConnection();
        List<Bil> alleBiler = new ArrayList<>(); // opretter en tom arraylist
        try {
            myPreparedStatement = myConnection.prepareStatement("SELECT * FROM bil");
            rs = myPreparedStatement.executeQuery();
            while (rs.next()) { // Initially the cursor is positioned before the first row. The next() method moves the cursor to the next row, and returns false if no rows are left

                Bil temp = new Bil( // instantierer et nyt objekt og kalder konstruktøren
                        rs.getInt(1), // tager værdierne fra resultsettet og
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

    @Override
    public void update(int id) {
        try {
            myConnection = DatabaseConnectionManager.getConnection();
            myPreparedStatement  = myConnection.prepareStatement(" UPDATE bil SET model = ? WHERE bil_ID = ?;");
            myPreparedStatement.setString(1, "Exela");
            myPreparedStatement.setInt(2,id);
            myPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) { // Delete i CRUD
        try {
            myConnection = DatabaseConnectionManager.getConnection();
            myPreparedStatement = myConnection.prepareStatement("DELETE FROM bil WHERE bil_ID = (?)");
            myPreparedStatement.setInt(1, id);
            int rows = myPreparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Entity is deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
