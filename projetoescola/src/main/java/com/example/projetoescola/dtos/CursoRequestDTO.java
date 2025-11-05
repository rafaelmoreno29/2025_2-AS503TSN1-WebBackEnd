package com.example.projetoescola.dtos;

import com.example.projetoescola.validations.NomeCursoValidation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "O nome do curso é obrigatório")
    @NomeCursoValidation(message = "Nome do curso fora do padrão")
    private String nome;
    @Min(value = 0, message = "A CH deve ser maior que zero")
    @Max(value = 4000, message = "A CH deve ser menor que 4000")
    private Integer cargaHoraria;
    private Integer idCategoriaCurso;
}
