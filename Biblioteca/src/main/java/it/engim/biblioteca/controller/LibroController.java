package it.engim.biblioteca.controller;

import it.engim.biblioteca.model.Libro;
import it.engim.biblioteca.repository.LibroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("biblioteca")//prefisso dell' indirizzo dei miei metodi
public class LibroController {

    //rendiamo la nostra applicazione accessibile al web consumando richieste di tipo rest json(controllare SOAP)



        @GetMapping("/salutami")
        public static String salutami() {
            return "Ciao dalla biblioteca!!";
        }

        @GetMapping("/getLibri")
        public static List<Libro> getLibri() //list percè mi torna un array
        {
            return LibroRepository.selezionaLibro();

        }

        @PostMapping("/insertLibro")
        public static String insertLibro(@RequestBody Libro libro)
        {
            return LibroRepository.aggiungiLibro(libro);
        }

        @GetMapping("/getLibriByGenere")
         public static List<Libro> getLibriByGenere(@RequestParam String genere)
        {
            return LibroRepository.selezionaLibroByGenere(genere);
        }

        }//end

