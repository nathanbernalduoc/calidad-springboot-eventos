package com.nathan.springboot_evento.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nathan.springboot_evento.dto.EventoDto;
import com.nathan.springboot_evento.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public CollectionModel<EntityModel<EventoDto>> getAllEventos() {

        List<EventoDto> eventos = eventoService.getAllEvento();
        List<EntityModel<EventoDto>> eventoResource = 
            eventos.stream().map(
                evento -> EntityModel.of(
                    evento,
                    WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(
                            this.getClass()
                        ).getEventoById(evento.getEventoId())
                    ).withSelfRel()
                )
            )
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEventos());
        CollectionModel<EntityModel<EventoDto>> resources = CollectionModel.of(eventoResource, linkTo.withRel("eventos"));

        return resources;
    }

    @GetMapping("/{id}")
    public EntityModel<EventoDto> getEventoById(@PathVariable Long id) {
        Optional<EventoDto> evento = eventoService.getEventoById(id);

        if (evento.isPresent()) {
            return EntityModel.of(evento.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEventoById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEventos()).withRel("all-eventos"));
        } else {
            throw new EventoNotFoundExcepcion("El evento no ha sido encontrado");
        }

    }

    @PostMapping
    public EntityModel<EventoDto> createEvento(@RequestBody EventoDto evento) {
        EventoDto createdEvento = eventoService.createEvento(evento);

        return EntityModel.of(createdEvento,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEventoById(createdEvento.getEventoId())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEventos()).withRel("all-eventos"));

    }

    @PutMapping({"/{id}"})
    public EntityModel<EventoDto> setEvento(@PathVariable Long id, @RequestBody EventoDto evento) {
        EventoDto updatedEvento = eventoService.updateEvento(id, evento);
        return EntityModel.of(updatedEvento,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEventoById(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEventos()).withRel("all-eventos"));
    }

    @DeleteMapping({"/{id}"})
    public void deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
    }

}
