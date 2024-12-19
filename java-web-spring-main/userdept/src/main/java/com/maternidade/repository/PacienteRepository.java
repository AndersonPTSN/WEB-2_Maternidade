package com.maternidade.repository;

import com.maternidade.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByNomeCompletoContaining(String nome);
}
