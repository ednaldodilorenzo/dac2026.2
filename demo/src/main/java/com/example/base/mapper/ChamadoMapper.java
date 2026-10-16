package com.example.base.mapper;

import com.example.base.dao.ChamadoRespDto;
import com.example.base.dto.ChamadoReqDto;
import com.example.base.model.Chamado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {
    @Mapping(constant = "ABERTO", target = "status")
    Chamado toEntity(ChamadoReqDto chamadoDto);

    ChamadoRespDto toDto(Chamado chamado);
}
