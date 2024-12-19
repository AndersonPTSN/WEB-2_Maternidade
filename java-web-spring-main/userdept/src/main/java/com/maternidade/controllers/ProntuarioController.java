package com.maternidade.controllers;

import com.maternidade.model.Prontuario;
import com.maternidade.service.ProntuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {
    @Autowired
    private ProntuarioService prontuarioService;

    @PostMapping
    public ResponseEntity<Prontuario> cadastrarProntuario(@RequestBody Prontuario prontuario) {
        return ResponseEntity.ok(prontuarioService.salvar(prontuario));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Prontuario> buscarProntuario(@PathVariable Long id) {
        return ResponseEntity.ok(prontuarioService.buscarPorId(id));
    }
    
    @GetMapping
    public List<Prontuario> listarProntuario() {
        return prontuarioService.findAll();
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTriagem(@PathVariable Long id) {
        if (prontuarioService.existsById(id)) {
        	prontuarioService.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        }
        return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o ID não existir
    }
}
