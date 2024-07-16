package br.com.igor.gestao_vagas.modules.candidate.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.igor.gestao_vagas.exceptions.UserFoundException;
import br.com.igor.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.igor.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@Service
public class CreateCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail()).ifPresent((user) -> {
         throw new UserFoundException();
      });

      var passwordCrypto = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(passwordCrypto);

      return this.candidateRepository.save(candidateEntity);
    }
}
