package es.acaex.biblioteca.services.elementos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.repositories.ItemsRepository;

@Service
public class EliminarElementoService {

    @Autowired
    ItemsRepository itemsRepository;

    public void execute(Long itemId) {
        itemsRepository.deleteById(itemId);
    }
}
