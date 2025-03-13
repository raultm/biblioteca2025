package es.acaex.biblioteca.services.socios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.dtos.MemberDetail;
import es.acaex.biblioteca.repositories.MembersRepository;

@Service
public class ListadoSociosService {

    /*
     * Modificar el Servicio:
     * Queremos el listado de socios ordenador por el nombre de usuario *
     */

    @Autowired
    MembersRepository membersRepository;

    public List<MemberDetail> execute() {

        // Haciendo SORT con el metodo de Collections
        //
        // List<Member> members = membersRepository.findAll();
        // Collections.sort(members);

        // return MemberDetail.fromMembersList(members);

        // Usando parametro sort con FindAll(Sort)
        // return MemberDetail.fromMembersList(
        // membersRepository.findAll(Sort.by(Sort.Direction.ASC, "nombreusuario")));

        // Creando un metodo en la interface
        return MemberDetail.fromMembersList(membersRepository.findAllByOrderByNombreusuarioDesc());
    }
}
