package es.acaex.biblioteca.services.socios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.dtos.MemberCreate;
import es.acaex.biblioteca.dtos.MemberDetail;
import es.acaex.biblioteca.models.Member;
import es.acaex.biblioteca.repositories.MembersRepository;

@Service
public class CrearSocioService {

    @Autowired
    MembersRepository membersRepository;

    public MemberDetail execute(MemberCreate memberCreate) {
        Member member = membersRepository.save(memberCreate.toMember());
        return MemberDetail.fromMember(member);
    }
}
