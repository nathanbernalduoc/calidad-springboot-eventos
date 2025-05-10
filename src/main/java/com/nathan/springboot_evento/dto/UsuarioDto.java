package com.nathan.springboot_evento.dto;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "EV_USUARIO")
public class UsuarioDto extends RepresentationModel<UsuarioDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_secuence")
    @SequenceGenerator(name = "usuario_secuence", sequenceName = "seq_usuario_id", allocationSize = 1)
    @Column(name = "usuario_id")
    private Long usuarioId;
    @Column(name = "alias")
    private String alias;
    @Column(name = "password")
    private String password;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "rol_id")
    private int rol;

    public UsuarioDto() {
    }

    public UsuarioDto(Long usuarioId, int rol, String alias, String password, String keyWord, String nombres, String apellidos, String direccion, int vigencia) {
        
        this.usuarioId = usuarioId;
        this.alias = alias;
        this.rol = rol;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Long getId() {
        return usuarioId;
    }

    public void setId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

}
