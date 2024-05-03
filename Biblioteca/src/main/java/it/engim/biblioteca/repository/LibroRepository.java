package it.engim.biblioteca.repository;

import it.engim.biblioteca.constants.DbConfig;
import it.engim.biblioteca.model.Libro;

import java.sql.*;
import java.util.*;

public class LibroRepository {

    public static List<Libro> selezionaLibro() {
        List<Libro> libroList = new ArrayList<>();
        try
        {
            Connection connection = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PPW);
            String query ="SELECT * FROM LIBRO";
            PreparedStatement statement = connection.prepareStatement(query);
            //statement serve a eseguore il comando e restituisce rs
            ResultSet rs = statement.executeQuery(); //solo per le SELECT
            while(rs.next())// passo dei dati di tipo ResultSEt e li faccio diventare di tipo list
            //usare while come se fosse un mapping
            {
                Libro b = new Libro( //conversione da DB a model
                        rs.getString("CODICE_ISBN"), //nome esatto della colonna del DATABASE// NON DEL MODEL
                        rs.getString("TITOLO"),
                        rs.getString("GENERE"),
                        rs.getString("ANNO_PUBBLICAZIONE"),
                        rs.getString("AUTORE")
                );
                libroList.add(b);
            }
            return libroList;
        }//end try
        catch(SQLException ex) //Exception va bene ma sqlexception è + mirato
        {
            System.out.println(ex.getMessage());
        } //end catch

        return new ArrayList<>();//da cancellare
    }

    //altra query
    public static String aggiungiLibro(Libro libro) {

        try
        {
            Connection connection = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PPW);
            String query ="INSERT INTO LIBRO (CODICE_ISBN,TITOLO,GENERE, ANNO_PUBBLICAZIONE, AUTORE) VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, libro.getCODICE_ISBN());
            statement.setString(2, libro.getTITOLO());
            statement.setString(3, libro.getGENERE());
            statement.setString(4, libro.getANNO_PUBBLICAZIONE());
            statement.setString(5, libro.getAUTORE());

           statement.executeUpdate();// per query che modificano INSERT UPDATE DELETE
            return "libro inserito";
        }//end try
        catch(SQLException ex) //Exception va bene ma sqlexception è + mirato
        {
            System.out.println(ex.getMessage());
        } //end catch

        return "errore inserimento libro";

    }

    public static List<Libro> selezionaLibroByGenere(String genere) {
        List<Libro> libroList = new ArrayList<>();
        try
        {
            Connection connection = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PPW);
            String query ="SELECT * FROM LIBRO WHERE GENERE =?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, genere);
            //statement serve a eseguore il comando e restituisce rs
            ResultSet rs = statement.executeQuery(); //solo per le SELECT
            while(rs.next())// passo dei dati di tipo ResultSEt e li faccio diventare di tipo list
            //usare while come se fosse un mapping
            {
                Libro b = new Libro( //conversione da DB a model
                        rs.getString("CODICE_ISBN"), //nome esatto della colonna del DATABASE// NON DEL MODEL
                        rs.getString("TITOLO"),
                        rs.getString("GENERE"),
                        rs.getString("ANNO_PUBBLICAZIONE"),
                        rs.getString("AUTORE")
                );
                libroList.add(b);
            }
            return libroList;
        }//end try
        catch(SQLException ex) //Exception va bene ma sqlexception è + mirato
        {
            System.out.println(ex.getMessage());
        } //end catch

        return new ArrayList<>();//da cancellare
    }

}
