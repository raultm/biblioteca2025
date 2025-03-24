package es.acaex.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acaex.biblioteca.models.Member;
import es.acaex.biblioteca.models.Rol;
import es.acaex.biblioteca.repositories.MembersRepository;
import es.acaex.biblioteca.repositories.RolesRepository;

@RestController
@RequestMapping("permisos")
public class PermisosController {

    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    MembersRepository membersRepository;

    @PostMapping("roles")
    public Rol crearRol(Rol rol) {
        return rolesRepository.save(rol);
    }

    @PostMapping("roles/{rolId}/members/{memberId}")
    public Rol asociarRolConSocio(
            @PathVariable("rolId") Long rolId,
            @PathVariable("memberId") Long memberId) {

        Member member = membersRepository.findById(memberId).orElseThrow();
        Rol rol = rolesRepository.findById(rolId).orElseThrow();

        List<Member> members = rol.getMembers();
        members.add(member);

        return rolesRepository.save(rol);
    }

}
