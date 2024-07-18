package br.com.igor.gestao_vagas.modules.company.services;

import java.time.Instant;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.igor.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.igor.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyService {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException{
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername())
        .orElseThrow(() -> {
            throw new UsernameNotFoundException("Username/Password da Compania nao foi encontrado !!!!");
        });

        // Varificar se Senha sao iguais da Company 
        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());
            // se nao for igual -> Erro 
            if (!passwordMatches) {
                throw new AuthenticationException();
            }
            // se for igual -> Gerar o token 
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            var token = JWT.create().withIssuer("Javagas")
            .withExpiresAt(Instant.now().plus(java.time.Duration.ofHours(2)))
            .withSubject(company.getId().toString())
            .sign(algorithm);

            return token;
    }
}
