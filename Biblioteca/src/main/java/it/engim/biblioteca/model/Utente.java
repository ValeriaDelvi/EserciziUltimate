package it.engim.biblioteca.model;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Utente implements Serializable
{
    private String CODICE_UTENTE;
    private String NOME;
    private String COGNOME;
}
