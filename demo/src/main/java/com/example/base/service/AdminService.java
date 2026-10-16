package com.example.base.service;

import com.example.base.dto.UsuarioReqDto;
import com.example.base.dto.UsuarioRespDto;

import java.util.List;

public interface AdminService {
    void salvar(UsuarioReqDto usuario);

    void salvarUsuario(UsuarioReqDto usuario);

    List<UsuarioRespDto> buscarTodos();
}
