package com.example.demo.service.usuario;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.dto.UsuarioReqDto;
import com.example.demo.dto.UsuarioRespDto;
import com.example.demo.model.Usuario;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;

    @Override
    @Transactional
    public void salvarUsuario(UsuarioReqDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.nome());
        usuario.setEmail(usuarioDto.email());
        usuario.setSenha(usuarioDto.senha());
        usuarioDao.save(usuario);
    }

    @Override
    public List<UsuarioRespDto> listarUsuarios() {
        return usuarioDao.findAll().stream().map(usuario -> new UsuarioRespDto(usuario.getId(), usuario.getNome(), usuario.getEmail())).toList();
    }

    @Override
    public UsuarioRespDto buscarUsuarioPorNome(String nome) {
        Usuario usuario = usuarioDao.findByNome(nome).get();
        return new UsuarioRespDto(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
