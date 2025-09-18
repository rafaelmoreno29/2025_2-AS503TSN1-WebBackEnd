package com.example.projetoescola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetoescola.models.CategoriaCurso;

public interface CategoriaCursoRepository
        extends JpaRepository<CategoriaCurso, Integer> {

}
