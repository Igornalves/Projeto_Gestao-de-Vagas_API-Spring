package br.com.igor.gestao_vagas.modules.candidate.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igor.gestao_vagas.modules.candidate.entities.CandidateEntity;

// Interface que define o repositório para a entidade CandidateEntity.
// Extende JpaRepository, o que fornece métodos CRUD prontos para uso.
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    // Método que busca um candidato pelo nome de usuário ou e-mail.
    // Retorna um Optional de CandidateEntity, permitindo verificar se o candidato foi encontrado.
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
