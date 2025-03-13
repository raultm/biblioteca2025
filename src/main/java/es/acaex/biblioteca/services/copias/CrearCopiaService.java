package es.acaex.biblioteca.services.copias;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.models.Copy;
import es.acaex.biblioteca.repositories.CopiesRepository;
import es.acaex.biblioteca.repositories.ItemsRepository;

@Service
public class CrearCopiaService {

    @Autowired
    CopiesRepository copiesRepository;
    @Autowired
    ItemsRepository itemsRepository;

    public Copy execute(Long itemId) {
        return copiesRepository.save(Copy.builder()
                .item(itemsRepository.findById(itemId).orElseThrow())
                .acquiredAt(LocalDate.now())
                .reservedBy(null)
                .build());
    }
}
