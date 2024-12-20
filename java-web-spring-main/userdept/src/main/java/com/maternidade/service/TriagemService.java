package com.maternidade.service;

import com.maternidade.model.Paciente;
import com.maternidade.model.Triagem;
import com.maternidade.repository.PacienteRepository;
import com.maternidade.repository.TriagemRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriagemService {
    @Autowired
    private TriagemRepository triagemRepository;
    
    @Autowired
    private PacienteRepository pacienteRepository;

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
    
    public Triagem atualizar(Long id, Triagem triagemAtualizada) {
        // Busca a triagem existente no banco de dados
        Triagem triagemExistente = triagemRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Triagem não encontrada"));

        // Atualiza os campos simples
        triagemExistente.setSinaisVitais(triagemAtualizada.getSinaisVitais());
        triagemExistente.setHistoricoMedico(triagemAtualizada.getHistoricoMedico());
        triagemExistente.setAvaliacaoPaciente(triagemAtualizada.getAvaliacaoPaciente());
        triagemExistente.setClassificacaoRisco(triagemAtualizada.getClassificacaoRisco());
        triagemExistente.setAvaliacaoEnfermeiro(triagemAtualizada.getAvaliacaoEnfermeiro());

        // Atualiza a relação com o paciente, se necessário
        if (triagemAtualizada.getPaciente() != null && triagemAtualizada.getPaciente().getId() != null) {
            Paciente paciente = pacienteRepository.findById(triagemAtualizada.getPaciente().getId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
            triagemExistente.setPaciente(paciente);
        }

        // Salva a triagem atualizada no banco de dados
        return triagemRepository.save(triagemExistente);
    }
}
