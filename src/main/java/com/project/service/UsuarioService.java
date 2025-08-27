package com.project.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.project.model.Usuario;
import com.project.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getById(UUID id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> cadastrarUsuario(Usuario usuario) {
        if(usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent()) {
            return Optional.empty();
        }

        //usuario.setSenha(criptografarSenha(usuario.getSenha()));

        return Optional.ofNullable((usuarioRepository.save(usuario)));
    }

    public Optional<Usuario> atualizarUsuario(Usuario usuario){
        if(usuarioRepository.findById(usuario.getId()).isPresent()) {

            Optional<Usuario> buscaUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());

            if ((buscaUsuario.isPresent()) && (buscaUsuario.get().getId() != usuario.getId()))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

            //usuario.setSenha(criptografarSenha(usuario.getSenha()));

            return Optional.ofNullable(usuarioRepository.save(usuario));
        }

        return Optional.empty();
    }

}
