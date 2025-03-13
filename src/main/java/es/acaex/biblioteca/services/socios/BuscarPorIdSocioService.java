package es.acaex.biblioteca.services.socios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.dtos.MemberDetail;
import es.acaex.biblioteca.repositories.MembersRepository;

@Service
public class BuscarPorIdSocioService {

    @Autowired
    MembersRepository membersRepository;

    public MemberDetail execute(Long memberId) {
        return MemberDetail.fromMember(membersRepository.findById(memberId).orElseThrow());
    }
}
