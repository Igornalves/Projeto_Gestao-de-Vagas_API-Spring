package br.com.igor.gestao_vagas.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.igor.gestao_vagas.exceptions.UserFoundException;
import br.com.igor.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.igor.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public CompanyEntity execute(CompanyEntity companyEntity){
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent((user) -> {
            throw new UserFoundException();
        });

        var passwordCrypto = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(passwordCrypto);

        return this.companyRepository.save(companyEntity);
    }

}
