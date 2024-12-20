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
    public Paciente atualizar(Long id, Paciente novoPaciente) {
        // Busca o paciente pelo ID
        return pacienteRepository.findById(id).map(pacienteExistente -> {
            // Atualiza os campos do paciente existente com os dados do novo paciente
            pacienteExistente.setNomeCompleto(novoPaciente.getNomeCompleto());
            pacienteExistente.setDataNascimento(novoPaciente.getDataNascimento());
            pacienteExistente.setTelefone(novoPaciente.getTelefone());
            pacienteExistente.setEmail(novoPaciente.getEmail());
            pacienteExistente.setCep(novoPaciente.getCep());
            pacienteExistente.setEndereco(novoPaciente.getEndereco());
            pacienteExistente.setNumero(novoPaciente.getNumero());
            pacienteExistente.setComplemento(novoPaciente.getComplemento());
            pacienteExistente.setBairro(novoPaciente.getBairro());
            pacienteExistente.setCidade(novoPaciente.getCidade());
            pacienteExistente.setRg(novoPaciente.getRg());
            pacienteExistente.setCpf(novoPaciente.getCpf());
            pacienteExistente.setIdade(novoPaciente.getIdade());
            pacienteExistente.setCartaoSus(novoPaciente.getCartaoSus());
            pacienteExistente.setNomeAcompanhante(novoPaciente.getNomeAcompanhante());
            pacienteExistente.setTelefoneAcompanhante(novoPaciente.getTelefoneAcompanhante());

            // Salva o paciente atualizado
            return pacienteRepository.save(pacienteExistente);
        }).orElseThrow(() -> new RuntimeException("Paciente com ID " + id + " não encontrado."));
    }
}
