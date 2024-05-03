package it.engim.biblioteca.repository;

import it.engim.biblioteca.constants.DbConfig;
import it.engim.biblioteca.model.Libro;
import it.engim.biblioteca.model.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteRepository {

    public static List<Utente> selezionaUtente(){
        List<Utente> listUtente = new ArrayList<>();
        try
        {
            Connection connection = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PPW);
            String query ="SELECT * FROM UTENTE";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(); //solo per le SELECT
            while(rs.next())
            {
                Utente u = new Utente( //conversione da DB a model
                        rs.getString("CODICE_UTENTE"),
                        rs.getString("NOME"),
                        rs.getString("COGNOME")
                );
                listUtente.add(u);
            }
            return listUtente;
        }//end try
        catch(SQLException ex) //Exception va bene ma sqlexception è + mirato
        {
            System.out.println(ex.getMessage());
        } //end catch

        return new ArrayList<>();//da cancellare
    }//end seleziona utente

    public static String aggiungiUtente(Utente utente) {

        try
        {
            Connection connection = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PPW);
            String query ="INSERT INTO UTENTE (CODICE_UTENTE,NOME,COGNOME) VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, utente.getCODICE_UTENTE());
            statement.setString(2, utente.getNOME());
            statement.setString(3, utente.getCOGNOME());

            statement.executeUpdate();// per query che modificano INSERT UPDATE DELETE
            return "utente inserito";
        }//end try
        catch(SQLException ex) //Exception va bene ma sqlexception è + mirato
        {
            System.out.println(ex.getMessage());
        } //end catch

        return "errore inserimento utente";

    }
    }// end repo
