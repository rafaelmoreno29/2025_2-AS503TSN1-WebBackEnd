package com.example.projetoescola.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.dtos.AutenticacaoDTO;
import com.example.projetoescola.dtos.TokenDTO;
import com.example.projetoescola.services.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping()
    public TokenDTO autenticar(@RequestBody AutenticacaoDTO autenticacao) {
        return usuarioService.autenticar(autenticacao);
    }
}
