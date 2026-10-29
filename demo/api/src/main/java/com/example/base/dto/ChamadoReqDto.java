package com.example.base.dto;

import com.example.base.model.CategoriaChamado;
import com.example.base.model.PrioridadeChamado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ChamadoReqDto(
        @NotBlank(message = "Título deve ser informado")
        @Length(min = 5, max = 100, message = "Título deve ter entre 5 e 100 caracteres")
        String titulo,

        @NotBlank(message = "Descrição deve ser informada")
        @Length(min = 10, max = 1000, message = "Título deve ter entre 10 e 1000 caracteres")
        String descricao,

        @NotNull(message = "Prioridade deve ser informada")
        PrioridadeChamado prioridade,

        @NotNull(message = "Categoria deve ser informada")
        CategoriaChamado categoria
) {}
