package br.com.igor.gestao_vagas.modules.company.services;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.igor.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.igor.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public void execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException{
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername())
        .orElseThrow(() -> {
            throw new UsernameNotFoundException("Compania nao foi encontrado");
        });

        // Varificar se Senha sao iguais da Company 
        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());
                // se nao for igual -> Erro 
                if (!passwordMatches) {
                    throw new AuthenticationException();
                }
                // se for igual -> Gerar o token 
                

    }
}
