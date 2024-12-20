package com.maternidade.controllers;

import com.maternidade.model.Triagem;
import com.maternidade.service.TriagemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/triagem")
public class TriagemController {
	
    @Autowired
    private TriagemService triagemService;

    @PostMapping
    public ResponseEntity<Triagem> cadastrarTriagem(@RequestBody Triagem triagem) {
        return ResponseEntity.ok(triagemService.salvar(triagem));
    }
	
    @GetMapping("/{id}")
    public ResponseEntity<Triagem> buscarTriagem(@PathVariable Long id) {
        return ResponseEntity.ok(triagemService.buscarPorId(id));
    }
    
    @GetMapping
    public List<Triagem> listarTriagem() {
        return triagemService.findAll();
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTriagem(@PathVariable Long id) {
        if (triagemService.existsById(id)) {
            triagemService.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        }
        return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o ID não existir
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Triagem> atualizarTriagem(@PathVariable Long id, @RequestBody Triagem triagemAtualizada) {
        if (!triagemService.existsById(id)) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o ID não existir
        }
        
        // Atualiza os dados e retorna a resposta
        Triagem triagemAtualizadaNoBanco = triagemService.atualizar(id, triagemAtualizada);
        return ResponseEntity.ok(triagemAtualizadaNoBanco);
    }
}
