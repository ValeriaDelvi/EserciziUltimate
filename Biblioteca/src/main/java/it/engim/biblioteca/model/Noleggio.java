package it.engim.biblioteca.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Noleggio  implements Serializable {
    private String CODICE_ISBN ;
    private String CODICE_UTENTE ;
    private String DATA_INIZIO_PRESTITO ;
    private String DATA_FINE_PRESTITO;
}
