package com.nathan.springboot_evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathan.springboot_evento.dto.EventoDto;

public interface EventoRepository extends JpaRepository<EventoDto, Long> {

}
