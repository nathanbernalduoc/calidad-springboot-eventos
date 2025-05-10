package com.nathan.springboot_evento.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "EV_EVENTO")

public class EventoDto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_secuence")
    @SequenceGenerator(name = "evento_secuence", sequenceName = "SEQ_EVENTO_ID", allocationSize = 1)
    @Column(name = "EVENTO_ID")
    private Long eventoId;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "USUARIO_ID")
    private Long usuarioId;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    EventoDto() {

    }

    EventoDto(Long eventoId, String nombre) {
        this.eventoId = eventoId;
        this.nombre = nombre;
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
