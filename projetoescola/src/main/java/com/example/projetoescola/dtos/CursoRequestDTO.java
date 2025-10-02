package com.example.projetoescola.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CursoRequestDTO {
    private Long id;
    private String nome;
    private Integer cargaHoraria;
    private Integer idCategoriaCurso;
}
