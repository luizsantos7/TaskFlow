package com.project.controler;

import com.project.model.Usuario;
import com.project.repository.UsuarioRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class UsuarioController {
    //getAll, getById, getByNome, getByUsuario, post, put, delete(menos importante de fazer)

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional> getById(@PathVariable UUID id){
        return ResponseEntity.ok(usuarioRepository.findById(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

}
