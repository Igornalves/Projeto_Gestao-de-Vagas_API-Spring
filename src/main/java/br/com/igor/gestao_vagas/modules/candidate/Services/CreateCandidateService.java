package br.com.igor.gestao_vagas.modules.candidate.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.igor.gestao_vagas.exceptions.UserFoundException;
import br.com.igor.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.igor.gestao_vagas.modules.candidate.repositories.CandidateRepository;

// Classe de serviço responsável pela criação de candidatos.
// A anotação @Service indica que esta classe é um componente de serviço do Spring.
@Service
public class CreateCandidateService {

  // Injeção de dependência do repositório de candidatos.
  @Autowired
  private CandidateRepository candidateRepository;

  // Injeção de dependência do PasswordEncoder para criptografar senhas.
  @Autowired
  private PasswordEncoder passwordEncoder;

  // Método que executa a lógica de criação de um candidato.
  public CandidateEntity execute(CandidateEntity candidateEntity) {
    // Verifica se já existe um usuário com o mesmo nome de usuário ou e-mail.
    // Se existir, lança uma exceção UserFoundException.
    this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) -> {
          throw new UserFoundException();
        });
    // Criptografa a senha do candidato antes de salvá-la no banco de dados.
    var passwordCrypto = passwordEncoder.encode(candidateEntity.getPassword());
    candidateEntity.setPassword(passwordCrypto);

    // Salva o candidato no repositório e retorna a entidade salva.
    return this.candidateRepository.save(candidateEntity);
  }
}
