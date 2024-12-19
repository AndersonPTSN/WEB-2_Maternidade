package com.maternidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maternidade.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
