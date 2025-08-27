package com.bene.sgbr.Controller;

import com.bene.sgbr.Service.BenneiroService;
import com.bene.sgbr.model.Benneiro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benneiros")
public class BenneiroController {

    private final BenneiroService service;

    public BenneiroController(BenneiroService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Benneiro>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Benneiro> buscarPorId(@PathVariable Long id) {
        Benneiro benneiro = service.buscarPorId(id);
        return benneiro != null ? ResponseEntity.ok(benneiro) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Benneiro> salvar(@RequestBody Benneiro beneiro) {
        return ResponseEntity.ok(service.salvar(beneiro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}