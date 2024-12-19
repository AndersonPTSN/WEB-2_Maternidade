package com.maternidade.service;

import com.maternidade.model.Medicacao;
import com.maternidade.repository.MedicacaoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicacaoService {
    @Autowired
    private MedicacaoRepository medicacaoRepository;

    public Medicacao salvar(Medicacao medicacao) {
        return medicacaoRepository.save(medicacao);
    }

    public Medicacao buscarPorId(Long id) {
        return medicacaoRepository.findById(id).orElse(null);
    }
    
    public List<Medicacao> findAll() {
        return medicacaoRepository.findAll();
    }
    
    public boolean existsById(Long id) {
        return medicacaoRepository.existsById(id);
    }

    public void deleteById(Long id) {
        if (!existsById(id)) {
            throw new RuntimeException("Triagem com o ID " + id + " não encontrada.");
        }
        medicacaoRepository.deleteById(id);
    }
}
