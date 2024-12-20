package com.maternidade.service;

import com.maternidade.model.Usuario;
import com.maternidade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario atualizar(Long id, Usuario novoUsuario) {
        // Busca o usuário pelo ID
        return usuarioRepository.findById(id).map(usuarioExistente -> {
            // Atualiza os campos do usuário existente com os dados do novo usuário
            usuarioExistente.setNomeCompleto(novoUsuario.getNomeCompleto());
            usuarioExistente.setDataNascimento(novoUsuario.getDataNascimento());
            usuarioExistente.setTelefone(novoUsuario.getTelefone());
            usuarioExistente.setEmail(novoUsuario.getEmail());
            usuarioExistente.setCep(novoUsuario.getCep());
            usuarioExistente.setEndereco(novoUsuario.getEndereco());
            usuarioExistente.setNumero(novoUsuario.getNumero());
            usuarioExistente.setComplemento(novoUsuario.getComplemento());
            usuarioExistente.setBairro(novoUsuario.getBairro());
            usuarioExistente.setCidade(novoUsuario.getCidade());
            usuarioExistente.setRg(novoUsuario.getRg());
            usuarioExistente.setCpf(novoUsuario.getCpf());
            usuarioExistente.setDepartamento(novoUsuario.getDepartamento());
            return usuarioRepository.save(usuarioExistente); // Salva a entidade atualizada
        }).orElseThrow(() -> new RuntimeException("Usuário com ID " + id + " não encontrado."));
    }
}

