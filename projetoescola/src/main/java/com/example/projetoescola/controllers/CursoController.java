package com.example.projetoescola.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.services.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public void criarCurso(@RequestBody CursoRequestDTO cursoRequestDTO) {
        cursoService.salvar(cursoRequestDTO);
    }
}
