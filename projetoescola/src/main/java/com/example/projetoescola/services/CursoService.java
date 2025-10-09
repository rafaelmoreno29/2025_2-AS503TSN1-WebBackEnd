package com.example.projetoescola.services;

import java.util.List;

import com.example.projetoescola.dtos.CursoDTO;
import com.example.projetoescola.dtos.CursoRequestDTO;

public interface CursoService {
    void salvar(CursoRequestDTO cursoRequestDTO);

    CursoDTO obterPorId(Long id);

    void remover(Long id);

    void editar(Long id, CursoRequestDTO cursoRequestDTO);

    List<CursoDTO> obterTodos();
}
