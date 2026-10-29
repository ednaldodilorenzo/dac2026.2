package com.example.demo.service.usuario;

import com.example.demo.dto.UsuarioReqDto;
import com.example.demo.dto.UsuarioRespDto;

import java.util.List;

public interface UsuarioService {
    void salvarUsuario(UsuarioReqDto usuarioDto);
    List<UsuarioRespDto> listarUsuarios();
    UsuarioRespDto buscarUsuarioPorNome(String nome);
}
