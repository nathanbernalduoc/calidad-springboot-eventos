package com.nathan.springboot_evento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathan.springboot_evento.dto.EventoDto;
import com.nathan.springboot_evento.repository.EventoRepository;

@Service
public class EventoServicelmpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;
    
    @Override
    public List<EventoDto> getAllEvento() {
        return eventoRepository.findAll();
    }

    @Override
    public Optional<EventoDto> getEventoById(Long id) {
        return eventoRepository.findById(id);
    }

    @Override
    public EventoDto createEvento(EventoDto evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public EventoDto updateEvento(Long id, EventoDto evento) {
        if (eventoRepository.existsById(id)) {
            evento.setEventoId(id);
            return eventoRepository.save(evento);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
