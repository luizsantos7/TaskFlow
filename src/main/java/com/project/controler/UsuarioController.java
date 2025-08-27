package com.project.controler;

import com.project.model.Usuario;
import com.project.repository.UsuarioRepository;
import com.project.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class UsuarioController {
    //getAll, getById, getByNome, getByUsuario, post, put, delete(menos importante de fazer)

    @Autowired
    private UsuarioService usuarioService;


}
