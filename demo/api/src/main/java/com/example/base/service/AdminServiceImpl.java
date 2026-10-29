package com.example.base.service;

import com.example.base.core.exception.APIException;
import com.example.base.core.exception.APIExceptionType;
import com.example.base.dao.UsuarioDao;
import com.example.base.dto.UsuarioReqDto;
import com.example.base.dto.UsuarioRespDto;
import com.example.base.model.PapelUsuario;
import com.example.base.model.Usuario;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UsuarioDao usuarioDao;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void salvar(UsuarioReqDto dto) {
        if (usuarioDao.existsByEmail(dto.email()))
            throw new APIException(APIExceptionType.BUSINESS_ERROR, "Email already exists!");

        String senhaCriptografada =  passwordEncoder.encode(dto.senha());
        IO.println("Antes " + dto.senha());
        IO.println("Depois " + senhaCriptografada);
        Usuario usuario = new Usuario(null, dto.nome(), dto.email(), senhaCriptografada,
                PapelUsuario.ADMIN);
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void salvarUsuario(UsuarioReqDto dto) {
        if (usuarioDao.existsByEmail(dto.email()))
            throw new APIException(APIExceptionType.BUSINESS_ERROR, "Email already exists!");

        String senhaCriptografada =  passwordEncoder.encode(dto.senha());
        Usuario usuario = new Usuario(null, dto.nome(), dto.email(), senhaCriptografada,
                PapelUsuario.USUARIO);
        usuarioDao.save(usuario);
    }


    @Override
    public List<UsuarioRespDto> buscarTodos() {
        List<Usuario> usuarios = usuarioDao.findAllByPapel(PapelUsuario.ADMIN);
        return usuarios.stream().map(u -> new UsuarioRespDto(u.getId(), u.getNome(), u.getEmail())).toList();
    }
}
