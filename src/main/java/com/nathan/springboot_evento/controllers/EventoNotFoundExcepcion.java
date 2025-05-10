package com.nathan.springboot_evento.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventoNotFoundExcepcion extends RuntimeException {

    public EventoNotFoundExcepcion(String message) {
        super(message);
    }
}
