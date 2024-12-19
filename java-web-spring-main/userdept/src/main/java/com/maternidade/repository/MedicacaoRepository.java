package com.maternidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maternidade.model.Medicacao;

public interface MedicacaoRepository extends JpaRepository<Medicacao, Long> {

}
