package br.com.igor.gestao_vagas.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependências.
import org.springframework.security.crypto.password.PasswordEncoder; // Importa a interface para codificação de senhas.
import org.springframework.stereotype.Service; // Importa a anotação que indica que a classe é um serviço.

import br.com.igor.gestao_vagas.exceptions.UserFoundException; // Importa a exceção personalizada para usuário já existente.
import br.com.igor.gestao_vagas.modules.company.entities.CompanyEntity; // Importa a entidade da empresa.
import br.com.igor.gestao_vagas.modules.company.repositories.CompanyRepository; // Importa o repositório da empresa.

@Service // Anotação que indica que esta classe é um serviço do Spring.
public class CreateCompanyService {

    @Autowired // Injeção de dependência do repositório de empresas.
    private CompanyRepository companyRepository;

    @Autowired // Injeção de dependência do codificador de senhas.
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        // Verifica se já existe uma empresa com o mesmo nome de usuário ou e-mail.
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException(); // Lança uma exceção se a empresa já existir.
                });

        // Codifica a senha fornecida usando o codificador de senhas.
        var passwordCrypto = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(passwordCrypto); // Define a senha codificada na entidade.

        // Salva a nova empresa no repositório e retorna a entidade salva.
        return this.companyRepository.save(companyEntity);
    }

}
