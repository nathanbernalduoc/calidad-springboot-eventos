package com.nathan.springboot_evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathan.springboot_evento.dto.UsuarioDto;

public interface UsuarioRepository extends JpaRepository<UsuarioDto, Long> {
    
}
