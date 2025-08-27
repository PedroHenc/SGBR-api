package com.bene.sgbr.Service;

import com.bene.sgbr.Repository.RelatorioRepository;
import com.bene.sgbr.model.Relatorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    private final RelatorioRepository repository;

    public RelatorioService(RelatorioRepository repository) {
        this.repository = repository;
    }

    public List<Relatorio> listarTodos() {
        return repository.findAll();
    }

    public Relatorio salvar(Relatorio relatorio) {
        return repository.save(relatorio);
    }

    public Relatorio buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

}
