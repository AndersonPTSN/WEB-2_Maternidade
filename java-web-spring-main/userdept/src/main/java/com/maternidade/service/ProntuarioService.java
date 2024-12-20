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
    public Prontuario atualizar(Long id, Prontuario novoProntuario) {
        // Busca o prontuário pelo ID
        return prontuarioRepository.findById(id).map(prontuarioExistente -> {
            // Atualiza os campos do prontuário existente com os dados do novo prontuário
            prontuarioExistente.setUnidadeSaude(novoProntuario.getUnidadeSaude());
            prontuarioExistente.setEndereco(novoProntuario.getEndereco());
            prontuarioExistente.setCodigo(novoProntuario.getCodigo());
            prontuarioExistente.setMunicipio(novoProntuario.getMunicipio());
            prontuarioExistente.setDataHoraInternacao(novoProntuario.getDataHoraInternacao());
            prontuarioExistente.setContato(novoProntuario.getContato());
            prontuarioExistente.setAnamnese(novoProntuario.getAnamnese());
            prontuarioExistente.setExameGeral(novoProntuario.getExameGeral());
            prontuarioExistente.setExamesLaboratoriais(novoProntuario.getExamesLaboratoriais());
            
            // Salva o prontuário atualizado
            return prontuarioRepository.save(prontuarioExistente);
        }).orElseThrow(() -> new RuntimeException("Prontuário com ID " + id + " não encontrado."));
    }
}
