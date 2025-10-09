package com.example.projetoescola.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.dtos.CursoDTO;
import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.services.CursoService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

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

    @GetMapping("{id}")
    public CursoDTO obterPorId(@PathVariable Long id) {
        return cursoService.obterPorId(id);
    }

    @GetMapping()
    public List<CursoDTO> obterTodos() {
        return cursoService.obterTodos();
    }

    @PutMapping("/{id}")
    public void editarCurso(@PathVariable Long id,
            @RequestBody CursoRequestDTO cursoRequestDTO) {
        cursoService.editar(id, cursoRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void removerCurso(@PathVariable Long id) {
        cursoService.remover(id);
    }
}
