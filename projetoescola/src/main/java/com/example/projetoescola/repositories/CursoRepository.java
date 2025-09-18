package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.projetoescola.models.Curso;

public interface CursoRepository
        extends JpaRepository<Curso, Long> {

    List<Curso> findByNomeLike(String nome);

    List<Curso> findByCargaHorariaGreaterThanEqual(Integer cargaHoraria);

    List<Curso> findByNomeAndCargaHorariaGreaterThanEqual(String nome, Integer cargaHoraria);

    @Query("select c from Curso c "
            + "where c.categoriaCurso.id = :idCategoria")
    List<Curso> findByIdCategoria(Integer idCategoria);
}
