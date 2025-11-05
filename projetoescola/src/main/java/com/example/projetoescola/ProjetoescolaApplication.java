package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired CategoriaCursoRepository categoriaCursoRepository) {
		return args -> {
			// Inserir categorias
			CategoriaCurso c1 = categoriaCursoRepository.save(
					new CategoriaCurso(null, "Tecnólogo", null));
			// Inserir cursos
			cursoRepository.save(
					new Curso(null, "Curso01", 2000, null));
			cursoRepository.save(
					new Curso(null, "Curso02", 2050, null));
			List<Curso> listaCursos = cursoRepository.findAll();
			listaCursos.forEach(System.out::println);
			// Associar cursos à categoria
			listaCursos.forEach(curso -> {
				curso.setCategoriaCurso(c1);
				cursoRepository.save(curso);
			});

			System.out.println("Cursos que começa com 'Jogos'");
			cursoRepository.findByNomeLike("Jogos%")
					.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}

}
