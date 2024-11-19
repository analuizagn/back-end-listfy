package projeto.listify.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.listify.entity.Lista;
import projeto.listify.service.IListaService;

import java.util.List;

@RestController
@RequestMapping("/api/listas")
public class ListaController {
    private final IListaService listaService;

    public ListaController(IListaService listaService) {
        this.listaService = listaService;
    }

    @PostMapping
    public ResponseEntity<Lista> createLista(@RequestBody Lista lista) {
        Lista createdLista = listaService.createLista(lista);
        return new ResponseEntity<>(createdLista, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Lista>> findAllListas() {
        List<Lista> listas = listaService.findAllListas();
        return ResponseEntity.ok(listas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lista> findListaById(@PathVariable Long id) {
        Lista lista = listaService.findListaById(id);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lista> updateLista(@PathVariable Long id, @RequestBody Lista lista) {
        Lista updatedLista = listaService.updateLista(id, lista);
        return ResponseEntity.ok(updatedLista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLista(@PathVariable Long id) {
        listaService.deleteLista(id);
        return ResponseEntity.noContent().build();
    }
}
