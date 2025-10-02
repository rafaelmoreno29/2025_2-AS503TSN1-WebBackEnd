package com.example.projetoescola.services;

import org.springframework.stereotype.Service;

import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.dtos.RegraNegocioException;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
    private CursoRepository cursoRepository;
    private CategoriaCursoRepository categoriaCursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository,
            CategoriaCursoRepository categoriaCursoRepository) {
        this.cursoRepository = cursoRepository;
        this.categoriaCursoRepository = categoriaCursoRepository;
    }

    @Override
    public void salvar(CursoRequestDTO cursoRequestDTO) {
        CategoriaCurso categ = categoriaCursoRepository.findById(
                cursoRequestDTO.getIdCategoriaCurso())
                .orElseThrow(
                        () -> new RegraNegocioException(
                                "Categoria de curso não encontrada."));

        Curso curso = new Curso();
        curso.setNome(cursoRequestDTO.getNome());
        curso.setCargaHoraria(cursoRequestDTO.getCargaHoraria());
        curso.setCategoriaCurso(categ);
        cursoRepository.save(curso);
    }
}
