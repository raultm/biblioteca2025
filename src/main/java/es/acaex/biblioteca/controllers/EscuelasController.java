package es.acaex.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acaex.biblioteca.models.Escuela;
import es.acaex.biblioteca.repositories.EscuelasRepository;

@RestController
@RequestMapping("escuelas")
public class EscuelasController {

    @Autowired
    EscuelasRepository escuelasRepository;

    @GetMapping
    public List<Escuela> mostrarEscuelas() {
        return escuelasRepository.findAll();
    }

    @PostMapping
    public Escuela guardarEscuela(Escuela escuela) {

        return escuelasRepository.save(escuela);
    }

}
