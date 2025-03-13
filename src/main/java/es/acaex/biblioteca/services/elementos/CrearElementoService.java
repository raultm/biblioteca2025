package es.acaex.biblioteca.services.elementos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.dtos.ItemCreate;
import es.acaex.biblioteca.dtos.ItemDetail;
import es.acaex.biblioteca.repositories.ItemsRepository;

@Service
public class CrearElementoService {

    @Autowired
    ItemsRepository itemsRepository;

    public ItemDetail execute(ItemCreate itemCreate) {
        return ItemDetail.fromItem(itemsRepository.save(itemCreate.toItem()));
    }
}
