package it.engim.biblioteca.model;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Libro implements Serializable
{
    private String CODICE_ISBN;
    private String TITOLO;
    private String GENERE;
    private String ANNO_PUBBLICAZIONE;
    private String AUTORE;
}
