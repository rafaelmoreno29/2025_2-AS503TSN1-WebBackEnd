package com.example.projetoescola.services;

import com.example.projetoescola.dtos.CursoDTO;
import com.example.projetoescola.dtos.CursoRequestDTO;

public interface CursoService {
    void salvar(CursoRequestDTO cursoRequestDTO);

    CursoDTO obterPorId(Long id);
}
