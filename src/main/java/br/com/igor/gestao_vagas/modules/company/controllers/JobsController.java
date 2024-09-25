package br.com.igor.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.gestao_vagas.modules.company.entities.JobsEntity;
import br.com.igor.gestao_vagas.modules.company.services.CreateJobsService;
import jakarta.validation.Valid;

// Controlador REST responsável por manipular requisições relacionadas a vagas de emprego.
@RestController
@RequestMapping("/jobs") // Define a rota base para as operações relacionadas a empregos.
public class JobsController {

    // Injeção de dependência do serviço que lida com a criação de novas vagas de
    // emprego.
    @Autowired
    private CreateJobsService jobsService;

    // Método que manipula requisições POST para criar uma nova vaga de emprego.
    @PostMapping("/create") // Define a rota específica para a criação de empregos.
    public JobsEntity create(@Valid @RequestBody JobsEntity jobsEntity) {
        // Chama o serviço de criação de empregos e retorna a entidade criada.
        return this.jobsService.execute(jobsEntity);
    }
}
