package com.example.base.controller;

import com.example.base.dao.ChamadoRespDto;
import com.example.base.dto.ChamadoReqDto;
import com.example.base.service.ChamadoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final ChamadoService chamadoService;

    @PostMapping("/{id}/chamados")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrar(@PathVariable Long id, @RequestBody @Valid ChamadoReqDto chamadoDto){
        chamadoService.salvar(id, chamadoDto);
    }

    @GetMapping("/{id}/chamados/abertos")
    public Page<ChamadoRespDto> buscarChamadosAbertos(@PathVariable Long id, @PageableDefault Pageable pageable){
        return chamadoService.buscarTodosAbertos(id, pageable);
    }
}
