package es.acaex.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.acaex.biblioteca.models.Escuela;

@Repository
public interface EscuelasRepository extends JpaRepository<Escuela, Long> {

}
