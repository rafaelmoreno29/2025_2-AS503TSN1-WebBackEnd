package com.example.projetoescola.repositories;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaCursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public CategoriaCurso salvar(CategoriaCurso categoriaCurso) {
        categoriaCurso = entityManager.merge(categoriaCurso);
        return categoriaCurso;
    }

    public List<CategoriaCurso> listarTodos() {
        String jpql = "SELECT c FROM CategoriaCurso c";
        return entityManager.createQuery(
                jpql, CategoriaCurso.class).getResultList();
    }

    public List<CategoriaCurso> obterPorNome(String nome) {
        String jpql = "SELECT c FROM CategoriaCurso c WHERE c.nome LIKE :nome";
        return entityManager.createQuery(jpql, CategoriaCurso.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    @Transactional
    public void excluir(int id) {
        CategoriaCurso categoriaCurso = entityManager.find(CategoriaCurso.class, id);
        excluir(categoriaCurso);
    }

    @Transactional
    public void excluir(CategoriaCurso categoriaCurso) {
        entityManager.remove(categoriaCurso);
    }

}
