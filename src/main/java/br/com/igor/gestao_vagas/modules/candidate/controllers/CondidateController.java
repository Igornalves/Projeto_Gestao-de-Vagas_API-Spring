package br.com.igor.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.gestao_vagas.modules.candidate.CandidateEntity;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/candidate")
public class CondidateController {

    @GetMapping("/get")
    public String TesteDaApi() {
       return "testando a APIs: teste funcionando corretamente";
    }
    
    @PostMapping("/create")
    public void create(@Valid @RequestBody CandidateEntity candidateEntity){
        System.out.println("candidato");
        System.out.println(candidateEntity.getEmail());
    }
}
