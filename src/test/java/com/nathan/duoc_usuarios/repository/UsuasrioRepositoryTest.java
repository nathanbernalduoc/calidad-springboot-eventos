package com.nathan.duoc_usuarios.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.nathan.springboot_evento.SpringbootEventosApplication;
import com.nathan.springboot_evento.dto.UsuarioDto;
import com.nathan.springboot_evento.repository.UsuarioRepository;

@DataJpaTest
@SpringBootTest(classes = SpringbootEventosApplication.class)
public class UsuasrioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void guardarUsuarioTest() {

        UsuarioDto usuario = new UsuarioDto();
        usuario.setApellidos("Perez");
        usuario.setNombres("Juan");
        usuario.setRol(2);
        usuario.setPassword("Contraseña1");
        usuario.setAlias("juanperez");

        UsuarioDto result = usuarioRepository.save(usuario);

        assertNotNull(result.getId());
        assertEquals("Juan", result.getNombres());

    }
    
}
