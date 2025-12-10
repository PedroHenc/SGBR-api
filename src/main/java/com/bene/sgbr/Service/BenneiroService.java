package com.bene.sgbr.Service;

import com.bene.sgbr.Repository.BenneiroRepository;
import com.bene.sgbr.model.Benneiro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenneiroService {
    private final BenneiroRepository repository;

    public BenneiroService(BenneiroRepository repository) {
        this.repository = repository;
    }

    public List<Benneiro> listarTodos() {
        return repository.findAll();
    }

    public Benneiro salvar(Benneiro beneiro) {
        return repository.save(beneiro);
    }

    public Benneiro editar (Benneiro beneiro) { return repository.save(beneiro); }

    public Benneiro buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
