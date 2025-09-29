package com.ryan.zianni.senac.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping ("/alunos")
public  class AlunoController {
    private List<String> alunos = new ArrayList<>();

    @GetMapping
    public List<String> listaralunos() {
        return alunos;
    }

    @PostMapping
    public String adicionaralunos(@RequestBody String nome) {
        alunos.add(nome);
        return "Aluno adicionado:" + nome;
    }

    @PutMapping ("/{id}")
    public String atualizaraluno(@PathVariable int id, @RequestBody String novoNome) {
        if (id >= 0 && id < alunos.size()) {
            alunos.set(id, novoNome);
            return "aluno atualizado para:" + novoNome;
        }
        return  "aluno nao encontrado";
    }

    @DeleteMapping ("/{id}")
    public String removeraluno(@PathVariable int id) {
        if (id >= 0 && id < alunos.size()) {
            String removido = alunos.remove(id);
            return "aluno removido " + removido;
        }
        return  "aluno nao encontrado";
    }
}
