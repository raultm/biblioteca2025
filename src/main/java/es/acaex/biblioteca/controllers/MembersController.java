package es.acaex.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@RestController
@RequestMapping("members")
public class MembersController {

    @Autowired
    MembersRepository repository;

    @GetMapping
    public List<MemberDetail> findAll() {
        return MemberDetail.fromMembersList(repository.findAll());
    }

    @PostMapping
    public MemberDetail save(MemberCreate memberCreate) {
        Member member = repository.save(memberCreate.toMember());
        return MemberDetail.fromMember(member);
    }

    @GetMapping("{memberId}")
    public MemberDetail findByid(@PathVariable("memberId") Long memberId) {
        return MemberDetail.fromMember(repository.findById(memberId).orElseThrow());
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
