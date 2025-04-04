package es.acaex.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.acaex.biblioteca.models.Member;

@Repository
public interface MembersRepository extends JpaRepository<Member, Long> {

    // List<Member> findAllByOrderByNombreusuario();

    List<Member> findAllByOrderByNombreusuarioDesc();

    Member findByNombreusuarioAndEmail(String nombreusuario, String email);

}
