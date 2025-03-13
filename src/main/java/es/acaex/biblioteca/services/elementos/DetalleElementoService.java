package es.acaex.biblioteca.services.elementos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.dtos.ItemDetail;
import es.acaex.biblioteca.repositories.ItemsRepository;

@Service
public class DetalleElementoService {

    @Autowired
    ItemsRepository repository;

    public ItemDetail execute(Long itemId) {
        return ItemDetail.fromItem(repository.findById(itemId).orElseThrow());
    }
}
