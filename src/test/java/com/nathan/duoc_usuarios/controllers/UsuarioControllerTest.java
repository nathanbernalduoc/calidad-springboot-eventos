package com.nathan.duoc_usuarios.controllers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.nathan.springboot_evento.controllers.UsuarioController;
import com.nathan.springboot_evento.dto.UsuarioDto;
import com.nathan.springboot_evento.service.UsuarioServicelmpl;

@WebMvcTest(UsuarioController.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UsuarioServicelmpl usuarioServiceMock;

    @Test
    public void obtenerTodoTest() throws Exception {

        UsuarioDto usuario1 = new UsuarioDto();
        usuario1.setRol(1);
        usuario1.setAlias("nathanbernal");
        usuario1.setPassword("123");
        usuario1.setNombres("Nathan");
        usuario1.setApellidos("Bernal");

        UsuarioDto usuario2 = new UsuarioDto();
        usuario2.setRol(2);
        usuario2.setAlias("usuarioTest");
        usuario2.setPassword("1122");
        usuario2.setNombres("Juan");
        usuario2.setApellidos("Test");

        List<UsuarioDto> usuarios = Arrays.asList(usuario1, usuario2);
        when(usuarioServiceMock.getAllUsuarios()).thenReturn(usuarios);

        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioDtoList[0].alias", Matchers.is("nathanbernal")))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioDtoList[0].direccion", Matchers.is("Avenida Test #12")));


    }
}
