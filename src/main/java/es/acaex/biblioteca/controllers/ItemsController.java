package es.acaex.biblioteca.controllers;

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
import es.acaex.biblioteca.services.copias.CrearCopiaService;
import es.acaex.biblioteca.services.copias.ListarCopiasPorElementoIdService;
import es.acaex.biblioteca.services.elementos.ActualizarElementoService;
import es.acaex.biblioteca.services.elementos.CrearElementoService;
import es.acaex.biblioteca.services.elementos.DetalleElementoService;
import es.acaex.biblioteca.services.elementos.EliminarElementoService;
import es.acaex.biblioteca.services.elementos.ListarElementosService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    CrearElementoService crearElementoService;
    @Autowired
    ListarElementosService listarElementosService;
    @Autowired
    DetalleElementoService detalleElementoService;
    @Autowired
    ActualizarElementoService actualizarElementoService;
    @Autowired
    EliminarElementoService eliminarElementoService;
    @Autowired
    CrearCopiaService crearCopiaService;
    @Autowired
    ListarCopiasPorElementoIdService listarCopiasPorElementoIdService;

    @PostMapping
    @Operation(operationId = "crearElemento", summary = "Creación de Elemento a través de información de Creación", tags = {
            "Elementos", "Prueba" })
    public ItemDetail save(ItemCreate itemCreate) {
        return crearElementoService.execute(itemCreate);
    }

    @GetMapping
    public List<ItemDetail> get() {
        return listarElementosService.execute();
    }

    @GetMapping("{itemId}")
    public ItemDetail findBy(@PathVariable("itemId") Long itemId) {
        return detalleElementoService.execute(itemId);
    }

    @PutMapping("{itemId}")
    public ItemDetail update(@PathVariable("itemId") Long itemId, ItemCreate itemCreate) {
        return actualizarElementoService.execute(itemId, itemCreate);
    }

    @DeleteMapping("{itemId}")
    public void delete(@PathVariable("itemId") Long itemId) {
        eliminarElementoService.execute(itemId);
        ;
    }

    @PostMapping("{itemId}/copies")
    public Copy crearCopia(@PathVariable("itemId") Long itemId) {
        return crearCopiaService.execute(itemId);
    }

    @GetMapping("{itemId}/copies")
    public List<Copy> listarCopias(@PathVariable("itemId") Long itemId) {
        return listarCopiasPorElementoIdService.execute(itemId);
    }
}