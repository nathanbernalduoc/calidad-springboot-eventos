package com.nathan.springboot_evento.service;

import java.util.List;
import java.util.Optional;

import com.nathan.springboot_evento.dto.EventoDto;

public interface EventoService {

    List<EventoDto> getAllEvento();
    Optional<EventoDto> getEventoById(Long id);
    
    EventoDto createEvento(EventoDto usuario);
    EventoDto updateEvento(Long id, EventoDto usuario);
    void deleteEvento(Long id);


}
