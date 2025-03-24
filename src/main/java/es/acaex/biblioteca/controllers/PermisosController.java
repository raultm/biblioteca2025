package es.acaex.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acaex.biblioteca.models.Rol;
import es.acaex.biblioteca.repositories.RolesRepository;

@RestController
@RequestMapping("permisos")
public class PermisosController {

    @Autowired
    RolesRepository rolesRepository;

    @PostMapping("rol")
    public Rol postMethodName(Rol rol) {
        return rolesRepository.save(rol);
    }

}
