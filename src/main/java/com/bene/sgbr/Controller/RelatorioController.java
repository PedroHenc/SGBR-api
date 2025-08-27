package com.bene.sgbr.Controller;


import com.bene.sgbr.Service.RelatorioService;
import com.bene.sgbr.model.Relatorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioService service;

    public RelatorioController(RelatorioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Relatorio>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relatorio> buscarPorId(@PathVariable Long id) {
        Relatorio relatorio = service.buscarPorId(id);
        return relatorio != null ? ResponseEntity.ok(relatorio) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Relatorio> salvar(@RequestBody Relatorio relatorio) {
        return ResponseEntity.ok(service.salvar(relatorio));
    }
}