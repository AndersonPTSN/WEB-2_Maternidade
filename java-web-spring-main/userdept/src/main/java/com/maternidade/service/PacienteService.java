package com.maternidade.service;

import com.maternidade.model.Paciente;
import com.maternidade.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }
    public List<Paciente> buscarPorNome(String nome) {
        return pacienteRepository.findByNomeCompletoContaining(nome);
    }
    
    public boolean existsById(Long id) {
        return pacienteRepository.existsById(id);
    }

    public void deleteById(Long id) {
        if (!existsById(id)) {
            throw new RuntimeException("Triagem com o ID " + id + " não encontrada.");
        }
        pacienteRepository.deleteById(id);
    }
}
