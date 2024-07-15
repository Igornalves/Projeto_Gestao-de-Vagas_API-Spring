package br.com.igor.gestao_vagas.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igor.gestao_vagas.modules.company.entities.JobsEntity;
import br.com.igor.gestao_vagas.modules.company.repositories.JobsRopository;

@Service
public class CreateJobsService {
    
    @Autowired
    private JobsRopository jobsRopository;

    public JobsEntity execute(JobsEntity jobsEntity) {
        return this.jobsRopository.save(jobsEntity);
    }
}
