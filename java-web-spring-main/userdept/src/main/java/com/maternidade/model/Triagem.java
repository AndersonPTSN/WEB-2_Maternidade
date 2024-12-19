package com.maternidade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_triagem")
public class Triagem {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private String nomePaciente;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;
    private String sinaisVitais;
    private String historicoMedico;
    private String avaliacaoPaciente;
    private String classificacaoRisco;
    private String avaliacaoEnfermeiro;

    // Getters e setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSinaisVitais() {
        return sinaisVitais;
    }

    public void setSinaisVitais(String sinaisVitais) {
        this.sinaisVitais = sinaisVitais;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public String getAvaliacaoPaciente() {
        return avaliacaoPaciente;
    }

    public void setAvaliacaoPaciente(String avaliacaoPaciente) {
        this.avaliacaoPaciente = avaliacaoPaciente;
    }

    public String getClassificacaoRisco() {
        return classificacaoRisco;
    }

    public void setClassificacaoRisco(String classificacaoRisco) {
        this.classificacaoRisco = classificacaoRisco;
    }

    public String getAvaliacaoEnfermeiro() {
        return avaliacaoEnfermeiro;
    }

    public void setAvaliacaoEnfermeiro(String avaliacaoEnfermeiro) {
        this.avaliacaoEnfermeiro = avaliacaoEnfermeiro;
    }

	public Paciente getPaciente() {
		return paciente;
	}

	public void setUsuario(Paciente paciente) {
		this.paciente = paciente;
	}
}
