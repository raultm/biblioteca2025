package es.acaex.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.acaex.biblioteca.models.Rol;

@Repository
public interface RolesRepository extends JpaRepository<Rol, Long> {

}
