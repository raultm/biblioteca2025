package es.acaex.biblioteca.services.copias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.models.Copy;
import es.acaex.biblioteca.repositories.CopiesRepository;

@Service
public class ListarCopiasPorElementoIdService {

    @Autowired
    CopiesRepository copiesRepository;

    public List<Copy> execute(Long itemId) {
        return copiesRepository.findById(itemId).orElseThrow().getCopies();
    }
}
