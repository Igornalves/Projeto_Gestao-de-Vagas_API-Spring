package br.com.igor.gestao_vagas.modules.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igor.gestao_vagas.modules.company.entities.JobsEntity;

public interface JobsRopository extends JpaRepository<JobsEntity, UUID> {

}
