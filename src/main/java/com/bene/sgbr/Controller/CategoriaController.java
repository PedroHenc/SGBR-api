package com.bene.sgbr.Controller;

import com.bene.sgbr.Service.CategoriaService;
import com.bene.sgbr.model.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        Categoria categoria = service.buscarPorId(id);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(service.salvar(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
