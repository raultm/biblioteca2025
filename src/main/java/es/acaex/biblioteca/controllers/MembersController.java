package es.acaex.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acaex.biblioteca.dtos.MemberCreate;
import es.acaex.biblioteca.dtos.MemberDetail;
import es.acaex.biblioteca.models.Member;
import es.acaex.biblioteca.repositories.MembersRepository;
import es.acaex.biblioteca.services.socios.BuscarPorIdSocioService;
import es.acaex.biblioteca.services.socios.CrearSocioService;
import es.acaex.biblioteca.services.socios.ListadoSociosService;

@RestController
@RequestMapping("members")
public class MembersController {

    @Autowired
    MembersRepository repository;
    @Autowired
    ListadoSociosService listadoSociosService;
    @Autowired
    CrearSocioService crearSocioService;
    @Autowired
    BuscarPorIdSocioService buscarPorIdSocioService;

    @GetMapping
    public List<MemberDetail> findAll() {
        return listadoSociosService.execute();
    }

    @PostMapping
    public MemberDetail save(MemberCreate memberCreate) {
        return crearSocioService.execute(memberCreate);
    }

    @GetMapping("{memberId}")
    public MemberDetail findByid(@PathVariable("memberId") Long memberId) {
        return buscarPorIdSocioService.execute(memberId);
    }

    @PutMapping("{memberId}")
    public MemberDetail updateById(@PathVariable("memberId") Long memberId, MemberCreate memberCreate) {
        Member member = memberCreate.toMember();
        member.setId(memberId);
        return MemberDetail.fromMember(repository.save(member));
    }

    @DeleteMapping("{memberId}")
    public void deleteById(@PathVariable("memberId") Long memberId) {
        repository.deleteById(memberId);
    }

}
