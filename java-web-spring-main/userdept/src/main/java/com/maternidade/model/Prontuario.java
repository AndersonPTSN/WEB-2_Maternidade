package com.maternidade.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_prontuario")
public class Prontuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String unidadeSaude;
    private String endereco;
    private String codigo;
    private String municipio;
    private Date dataHoraInternacao;
    private String contato;
    private String anamnese;
    private String exameGeral;
    private String examesLaboratoriais;

    // Getters e setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnidadeSaude() {
        return unidadeSaude;
    }

    public void setUnidadeSaude(String unidadeSaude) {
        this.unidadeSaude = unidadeSaude;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Date getDataHoraInternacao() {
        return dataHoraInternacao;
    }

    public void setDataHoraInternacao(Date dataHoraInternacao) {
        this.dataHoraInternacao = dataHoraInternacao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getExameGeral() {
        return exameGeral;
    }

    public void setExameGeral(String exameGeral) {
        this.exameGeral = exameGeral;
    }

    public String getExamesLaboratoriais() {
        return examesLaboratoriais;
    }

    public void setExamesLaboratoriais(String examesLaboratoriais) {
        this.examesLaboratoriais = examesLaboratoriais;
    }
}
