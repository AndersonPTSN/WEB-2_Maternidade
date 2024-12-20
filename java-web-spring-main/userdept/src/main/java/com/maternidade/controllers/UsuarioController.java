package com.maternidade.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maternidade.model.Usuario;
import com.maternidade.repository.UsuarioRepository;
import com.maternidade.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
    @Autowired
    private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> listarUsuarios() {
		return repository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Usuario buscarUsuario(@PathVariable Long id) {
		return repository.findById(id).get();
	}

	@PostMapping
	public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
	    if (repository.existsById(id)) {
	        repository.deleteById(id);
	        return ResponseEntity.noContent().build(); // Retorna 204 No Content
	    }
	    return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o ID não existir
	}

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario novoUsuario) {
        Usuario usuarioAtualizado = usuarioService.atualizar(id, novoUsuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }
}
