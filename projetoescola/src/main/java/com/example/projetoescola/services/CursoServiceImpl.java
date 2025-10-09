package com.example.projetoescola.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projetoescola.dtos.CategoriaCursoDTO;
import com.example.projetoescola.dtos.CursoDTO;
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

        @Override
        public CursoDTO obterPorId(Long id) {
                return cursoRepository.findById(id)
                                .map((Curso c) -> {
                                        return CursoDTO.builder()
                                                        .id(c.getId())
                                                        .nome(c.getNome())
                                                        .cargaHoraria(c.getCargaHoraria())
                                                        .categoria(
                                                                        CategoriaCursoDTO.builder()
                                                                                        .id(c.getCategoriaCurso()
                                                                                                        .getId())
                                                                                        .nome(c.getCategoriaCurso()
                                                                                                        .getNome())
                                                                                        .build())
                                                        .build();
                                })
                                .orElseThrow(
                                                () -> new RegraNegocioException("Curso não encontrado."));
        }

        @Override
        public void remover(Long id) {
                cursoRepository.deleteById(id);
        }

        @Override
        public void editar(Long id, CursoRequestDTO cursoRequestDTO) {
                Curso curso = cursoRepository.findById(id)
                                .orElseThrow(
                                                () -> new RegraNegocioException("Curso não encontrado."));

                CategoriaCurso categ = categoriaCursoRepository.findById(
                                cursoRequestDTO.getIdCategoriaCurso())
                                .orElseThrow(
                                                () -> new RegraNegocioException(
                                                                "Categoria de curso não encontrada."));
                curso.setNome(cursoRequestDTO.getNome());
                curso.setCargaHoraria(cursoRequestDTO.getCargaHoraria());
                curso.setCategoriaCurso(categ);
                cursoRepository.save(curso);
        }

        @Override
        public List<CursoDTO> obterTodos() {
                return cursoRepository.findAll()
                                .stream().map((Curso c) -> {
                                        return CursoDTO.builder()
                                                        .id(c.getId())
                                                        .nome(c.getNome())
                                                        .cargaHoraria(c.getCargaHoraria())
                                                        .categoria(
                                                                        CategoriaCursoDTO.builder()
                                                                                        .id(c.getCategoriaCurso()
                                                                                                        .getId())
                                                                                        .nome(c.getCategoriaCurso()
                                                                                                        .getNome())
                                                                                        .build())
                                                        .build();
                                }).toList();
        }
}
