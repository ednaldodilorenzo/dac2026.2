package com.example.base.controller;

import com.example.base.dao.ChamadoRespDto;
import com.example.base.dto.ChamadoReqDto;
import com.example.base.dto.UsuarioLogadoDto;
import com.example.base.service.ChamadoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/chamados")
@AllArgsConstructor
public class ChamadoController {
    private final ChamadoService chamadoService;

    @GetMapping("/me")
    public Page<ChamadoRespDto> buscarChamadosDoUsuario(@AuthenticationPrincipal UsuarioLogadoDto usuario, @PageableDefault Pageable pageable) {
        return chamadoService.buscarTodosAbertos(usuario.id(), pageable);
    }

    @PostMapping
    public void salvar(@AuthenticationPrincipal UsuarioLogadoDto usuario, @RequestBody @Valid ChamadoReqDto dto) {
        chamadoService.salvar(usuario.id(), dto);
    }
}
