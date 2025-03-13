package es.acaex.biblioteca.services.elementos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.dtos.ItemCreate;
import es.acaex.biblioteca.dtos.ItemDetail;
import es.acaex.biblioteca.models.Item;
import es.acaex.biblioteca.repositories.ItemsRepository;

@Service
public class ActualizarElementoService {

    @Autowired
    ItemsRepository itemsRepository;

    public ItemDetail execute(Long itemId, ItemCreate itemCreate) {
        Item item = itemCreate.toItem();
        item.setId(itemId);
        return ItemDetail.fromItem(itemsRepository.save(item));
    }
}
