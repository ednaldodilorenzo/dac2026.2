package com.example.base.service;

import com.example.base.dao.ChamadoRespDto;
import com.example.base.dto.ChamadoReqDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChamadoService {
    void salvar(Long idUsuario, ChamadoReqDto chamadoDto);

    Page<ChamadoRespDto> buscarTodosAbertos(Long idUsuario, Pageable pageable);
}
