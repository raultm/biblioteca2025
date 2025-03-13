package es.acaex.biblioteca.services.elementos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.dtos.ItemCreate;
import es.acaex.biblioteca.dtos.ItemDetail;
import es.acaex.biblioteca.models.Item;
import es.acaex.biblioteca.repositories.ItemsRepository;
import es.acaex.biblioteca.services.copias.CrearCopiaService;

@Service
public class CrearElementoService {

    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    CrearCopiaService crearCopiaService;

    public ItemDetail execute(ItemCreate itemCreate) {

        Item item = itemsRepository.save(itemCreate.toItem());

        for (int i = 0; i < itemCreate.getNumCopias(); i++) {
            crearCopiaService.execute(item.getId());
        }

        return ItemDetail.fromItem(item);
    }
}
