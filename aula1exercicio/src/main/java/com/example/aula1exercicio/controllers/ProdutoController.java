package com.example.aula1exercicio.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;

import com.example.aula1exercicio.models.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    ArrayList<Produto> produtos = new ArrayList<>();

    @PostMapping("")
    public String inserir(@RequestBody Produto produto) {
        produtos.add(produto);
        return "Produto inserido com sucesso!";
    }

    @GetMapping("")
    public ArrayList<Produto> listarTodos() {
        return produtos;
    }

}
