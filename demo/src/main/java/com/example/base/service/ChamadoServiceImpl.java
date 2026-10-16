package com.example.base.service;

import com.example.base.core.exception.APIException;
import com.example.base.core.exception.APIExceptionType;
import com.example.base.dao.ChamadoDao;
import com.example.base.dao.ChamadoRespDto;
import com.example.base.dao.UsuarioDao;
import com.example.base.dto.ChamadoReqDto;
import com.example.base.mapper.ChamadoMapper;
import com.example.base.model.Chamado;
import com.example.base.model.StatusChamado;
import com.example.base.model.Usuario;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChamadoServiceImpl implements ChamadoService {

    private final ChamadoDao chamadoDao;
    private final UsuarioDao usuarioDao;
    private final ChamadoMapper chamadoMapper;

    @Override
    @Transactional
    public void salvar(Long idUsuario, ChamadoReqDto chamadoDto) {
        Usuario usuario = usuarioDao.findById(idUsuario).orElseThrow(() -> new APIException(APIExceptionType.NOT_FOUND, "User with id " + idUsuario + " does not exist!"));

        Chamado chamado = chamadoMapper.toEntity(chamadoDto);
        chamado.setUsuario(usuario);
        this.chamadoDao.save(chamado);
    }

    @Override
    public Page<ChamadoRespDto> buscarTodosAbertos(Long idUsuario, @PageableDefault(sort = "titulo", direction =
            Sort.Direction.ASC) Pageable pageable) {
        return chamadoDao
                .findAllByUsuario_IdAndStatus(idUsuario,
                        StatusChamado.ABERTO, pageable)
                .map(chamadoMapper::toDto);
    }
}
