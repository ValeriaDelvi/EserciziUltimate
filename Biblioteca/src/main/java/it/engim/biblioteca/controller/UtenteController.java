package it.engim.biblioteca.controller;

import it.engim.biblioteca.model.Libro;
import it.engim.biblioteca.model.Utente;
import it.engim.biblioteca.repository.LibroRepository;
import it.engim.biblioteca.repository.UtenteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("biblioteca")
public class UtenteController {

    @GetMapping("/getUtenti")
    public static List<Utente> getUtenti()
    {
        return UtenteRepository.selezionaUtenti();

    }

    @PostMapping("/addUtenti")
    public static


}//end controller
