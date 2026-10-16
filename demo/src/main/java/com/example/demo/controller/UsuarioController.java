package com.example.demo.controller;

import com.example.demo.dto.UsuarioReqDto;
import com.example.demo.dto.UsuarioRespDto;
import com.example.demo.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarUsuario(@RequestBody UsuarioReqDto usuarioDto) {
        usuarioService.salvarUsuario(usuarioDto);
    }

    @GetMapping
    public List<UsuarioRespDto> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
}
