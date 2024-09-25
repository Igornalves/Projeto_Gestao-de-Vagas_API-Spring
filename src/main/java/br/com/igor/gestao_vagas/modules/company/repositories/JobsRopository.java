package br.com.igor.gestao_vagas.modules.company.repositories;

import java.util.UUID; // Importa a classe UUID para identificação única.

import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository para operações de banco de dados.

import br.com.igor.gestao_vagas.modules.company.entities.JobsEntity; // Importa a entidade JobsEntity.

public interface JobsRopository extends JpaRepository<JobsEntity, UUID> {
    // Esta interface estende JpaRepository, que fornece métodos CRUD para a
    // entidade JobsEntity.
    // O tipo de ID utilizado é UUID, garantindo que cada JobsEntity tenha uma
    // identificação única.
}
