package com.example.base.dao;

import com.example.base.model.PapelUsuario;
import com.example.base.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByPapel(PapelUsuario papel);

    Boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);
}
