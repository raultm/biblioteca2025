package es.acaex.biblioteca.services.elementos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.dtos.ItemDetail;
import es.acaex.biblioteca.repositories.ItemsRepository;

@Service
public class ListarElementosService {

    @Autowired
    ItemsRepository repository;

    public List<ItemDetail> execute() {
        return ItemDetail.fromItemsList(repository.findAll());
    }
}
