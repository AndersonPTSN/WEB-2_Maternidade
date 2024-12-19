package com.maternidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maternidade.model.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {

}
