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
    public Medicacao atualizar(Long id, Medicacao novaMedicacao) {
        // Busca a medicação pelo ID
        return medicacaoRepository.findById(id).map(medicacaoExistente -> {
            // Atualiza os campos da medicação existente com os dados da nova medicação
            medicacaoExistente.setMedicacao(novaMedicacao.getMedicacao());
            medicacaoExistente.setFrequencia(novaMedicacao.getFrequencia());
            medicacaoExistente.setDataHoraUltimaDose(novaMedicacao.getDataHoraUltimaDose());
            medicacaoExistente.setPaciente(novaMedicacao.getPaciente());

            // Salva a medicação atualizada
            return medicacaoRepository.save(medicacaoExistente);
        }).orElseThrow(() -> new RuntimeException("Medicação com ID " + id + " não encontrada."));
    }
}
