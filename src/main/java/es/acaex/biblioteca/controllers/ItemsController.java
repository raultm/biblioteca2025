package es.acaex.biblioteca.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acaex.biblioteca.dtos.ItemCreate;
import es.acaex.biblioteca.dtos.ItemDetail;
import es.acaex.biblioteca.models.Copy;
import es.acaex.biblioteca.models.Item;
import es.acaex.biblioteca.repositories.CopiesRepository;
import es.acaex.biblioteca.repositories.ItemsRepository;

@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    ItemsRepository repository;
    @Autowired
    CopiesRepository copiesRepository;

    @PostMapping
    public ItemDetail save(ItemCreate itemCreate) {
        return ItemDetail.fromItem(repository.save(itemCreate.toItem()));
    }

    @GetMapping
    public List<ItemDetail> get() {
        return ItemDetail.fromItemsList(repository.findAll());
    }

    @GetMapping("{itemId}")
    public ItemDetail findBy(@PathVariable("itemId") Long itemId) {
        return ItemDetail.fromItem(repository.findById(itemId).orElseThrow());
    }

    @PutMapping("{itemId}")
    public ItemDetail update(@PathVariable("itemId") Long itemId, ItemCreate itemCreate) {
        Item item = itemCreate.toItem();
        item.setId(itemId);
        return ItemDetail.fromItem(repository.save(item));
    }

    @DeleteMapping("{itemId}")
    public void delete(@PathVariable("itemId") Long itemId) {
        repository.deleteById(itemId);
    }

    @PostMapping("{itemId}/copies")
    public Copy crearCopia(@PathVariable("itemId") Long itemId) {
        return copiesRepository.save(Copy.builder()
                .item(repository.findById(itemId).orElseThrow())
                .acquiredAt(LocalDate.now())
                .reservedBy(null)
                .build());
    }

    @GetMapping("{itemId}/copies")
    public List<Copy> listarCopias(@PathVariable("itemId") Long itemId) {
        return repository.findById(itemId).orElseThrow().getCopies();
    }
}