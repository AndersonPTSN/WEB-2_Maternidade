package com.maternidade.service;

import com.maternidade.model.Triagem;
import com.maternidade.repository.TriagemRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriagemService {
    @Autowired
    private TriagemRepository triagemRepository;

    public Triagem salvar(Triagem triagem) {
        return triagemRepository.save(triagem);
    }

    public Triagem buscarPorId(Long id) {
        return triagemRepository.findById(id).orElse(null);
    }
    
    public List<Triagem> findAll() {
        return triagemRepository.findAll();
    }
    
    public boolean existsById(Long id) {
        return triagemRepository.existsById(id);
    }

    public void deleteById(Long id) {
        if (!existsById(id)) {
            throw new RuntimeException("Triagem com o ID " + id + " não encontrada.");
        }
        triagemRepository.deleteById(id);
    }
}
