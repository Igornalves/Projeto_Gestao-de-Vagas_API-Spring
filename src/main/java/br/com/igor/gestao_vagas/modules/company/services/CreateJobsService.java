package br.com.igor.gestao_vagas.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependências.
import org.springframework.stereotype.Service; // Importa a anotação que indica que a classe é um serviço.

import br.com.igor.gestao_vagas.modules.company.entities.JobsEntity; // Importa a entidade de trabalhos.
import br.com.igor.gestao_vagas.modules.company.repositories.JobsRopository; // Importa o repositório de trabalhos.

@Service // Indica que esta classe é um serviço do Spring.
public class CreateJobsService {

    @Autowired // Injeção de dependência do repositório de trabalhos.
    private JobsRopository jobsRopository;

    // Método para salvar uma nova entidade de trabalho.
    public JobsEntity execute(JobsEntity jobsEntity) {
        return this.jobsRopository.save(jobsEntity); // Salva a entidade de trabalho e retorna a entidade salva.
    }
}
