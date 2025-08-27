package com.project.repository;

import com.project.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository <Usuario, UUID>{
    Optional<Usuario> findByUsuario(String Usuario);
    Optional<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}
