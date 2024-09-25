package br.com.igor.gestao_vagas.modules.company.services;

import java.time.Instant; // Importa a classe Instant para trabalhar com timestamps.

import javax.naming.AuthenticationException; // Importa a exceção de autenticação.

import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependências.
import org.springframework.beans.factory.annotation.Value; // Importa a anotação para ler valores de propriedades.
import org.springframework.security.core.userdetails.UsernameNotFoundException; // Importa a exceção para usuários não encontrados.
import org.springframework.security.crypto.password.PasswordEncoder; // Importa a interface para codificação de senhas.
import org.springframework.stereotype.Service; // Importa a anotação que indica que a classe é um serviço.

import com.auth0.jwt.JWT; // Importa a classe JWT para criação de tokens.
import com.auth0.jwt.algorithms.Algorithm; // Importa a classe Algorithm para especificar algoritmos de assinatura.

import br.com.igor.gestao_vagas.modules.company.dto.AuthCompanyDTO; // Importa o DTO de autenticação da empresa.
import br.com.igor.gestao_vagas.modules.company.repositories.CompanyRepository; // Importa o repositório da empresa.

@Service // Anotação que indica que a classe é um serviço do Spring.
public class AuthCompanyService {

    @Value("${security.token.secret}") // Lê a chave secreta da configuração.
    private String secretKey;

    @Autowired // Injeção de dependência do repositório de empresas.
    private CompanyRepository companyRepository;

    @Autowired // Injeção de dependência do codificador de senhas.
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        // Busca a empresa pelo nome de usuário fornecido no DTO.
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername())
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("Username/Password da Compania nao foi encontrado !!!!");
                });

        // Verifica se a senha fornecida corresponde à senha armazenada da empresa.
        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());
        // Se a senha não corresponder, lança uma exceção de autenticação.
        if (!passwordMatches) {
            throw new AuthenticationException();
        }
        // Se as senhas corresponderem, gera um token JWT
        Algorithm algorithm = Algorithm.HMAC256(secretKey); // Define o algoritmo de assinatura.

        // Cria o token JWT com as informações da empresa.
        var token = JWT.create().withIssuer("Javagas") // Define o emissor do token.
                .withExpiresAt(Instant.now().plus(java.time.Duration.ofHours(2))) // Define a expiração do token.
                .withSubject(company.getId().toString()) // Define o assunto do token como o ID da empresa.
                .sign(algorithm); // Assina o token com o algoritmo definido.

        return token; // Retorna o token gerado.
    }
}
