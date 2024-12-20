package com.maternidade.controllers;

import com.maternidade.model.Medicacao;
import com.maternidade.service.MedicacaoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicacoes")
public class MedicacaoController {
    @Autowired
    private MedicacaoService medicacaoService;

    @PostMapping
    public ResponseEntity<Medicacao> cadastrarMedicacao(@RequestBody Medicacao medicacao) {
        return ResponseEntity.ok(medicacaoService.salvar(medicacao));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Medicacao> buscarTriagem(@PathVariable Long id) {
        return ResponseEntity.ok(medicacaoService.buscarPorId(id));
    }
    
    @GetMapping
    public List<Medicacao> listarTriagem() {
        return medicacaoService.findAll();
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTriagem(@PathVariable Long id) {
        if (medicacaoService.existsById(id)) {
        	medicacaoService.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        }
        return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o ID não existir
    }
    @PutMapping("/{id}")
    public ResponseEntity<Medicacao> atualizarMedicacao(@PathVariable Long id, @RequestBody Medicacao novaMedicacao) {
        Medicacao medicacaoAtualizada = medicacaoService.atualizar(id, novaMedicacao);
        return ResponseEntity.ok(medicacaoAtualizada);
    }
}
