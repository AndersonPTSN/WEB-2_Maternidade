package com.maternidade.service;

import com.maternidade.model.Prontuario;
import com.maternidade.repository.ProntuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProntuarioService {
    @Autowired
    private ProntuarioRepository prontuarioRepository;

    public Prontuario salvar(Prontuario prontuario) {
        return prontuarioRepository.save(prontuario);
    }

    public Prontuario buscarPorId(Long id) {
        return prontuarioRepository.findById(id).orElse(null);
    }
    
    public List<Prontuario> findAll() {
        return prontuarioRepository.findAll();
    }
    
    public boolean existsById(Long id) {
        return prontuarioRepository.existsById(id);
    }

    public void deleteById(Long id) {
        if (!existsById(id)) {
            throw new RuntimeException("Triagem com o ID " + id + " não encontrada.");
        }
        prontuarioRepository.deleteById(id);
    }
}
