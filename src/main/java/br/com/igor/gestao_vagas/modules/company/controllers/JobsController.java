package br.com.igor.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.gestao_vagas.modules.company.entities.JobsEntity;
import br.com.igor.gestao_vagas.modules.company.services.CreateJobsService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/jobs")
public class JobsController {
    
    @Autowired
    private CreateJobsService jobsService;

    @PostMapping("/create")
    public JobsEntity create(@Valid @RequestBody JobsEntity jobsEntity){
        return this.jobsService.execute(jobsEntity);
    }
}
