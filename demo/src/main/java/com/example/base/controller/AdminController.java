package com.example.base.controller;

import com.example.base.dto.UsuarioReqDto;
import com.example.base.dto.UsuarioRespDto;
import com.example.base.service.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admins")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public void registrar(@RequestBody @Valid UsuarioReqDto usuario){
        adminService.salvar(usuario);
    }

    @GetMapping
    public List<UsuarioRespDto> listar(){
        return adminService.buscarTodos();
    }
}
