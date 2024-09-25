package br.com.igor.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp; // Anotação para gerar automaticamente o timestamp de criação.
import org.hibernate.validator.constraints.Length; // Anotação para validação de comprimento de string.

import jakarta.persistence.Entity; // Anotação para indicar que a classe é uma entidade JPA.
import jakarta.persistence.GeneratedValue; // Anotação para gerar automaticamente o valor da chave primária.
import jakarta.persistence.GenerationType; // Estratégia de geração de valores para a chave primária.
import jakarta.persistence.Id; // Anotação para indicar o campo da chave primária.
import jakarta.validation.constraints.Email; // Anotação para validar que o campo é um e-mail válido.
import jakarta.validation.constraints.Pattern; // Anotação para validação de padrões regex.
import lombok.Data; // Anotação Lombok para gerar automaticamente métodos comuns.

@Entity(name = "company") // Define que esta classe será mapeada para a tabela "company".
@Data // Gera automaticamente os métodos getters, setters, toString, equals e
      // hashCode.
public class CompanyEntity {

    @Id // Indica que este campo é a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.UUID) // Gera um UUID automaticamente para cada nova instância.
    private UUID id; // Identificador único da empresa.

    @Pattern(regexp = "\\S+", message = "O campo [username] nao deve conter espaco") // Valida que o username não contém
                                                                                     // espaços.
    private String username; // Nome de usuário da empresa.

    @Email(message = "o campo deve conter um e-mail valido") // Valida que o e-mail está em um formato correto.
    private String email; // E-mail da empresa.

    @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres") // Valida o comprimento
                                                                                                // da senha.
    private String password; // Senha da empresa.

    private String name; // Nome da empresa.
    private String website; // URL do website da empresa.
    private String description; // Descrição da empresa.

    @CreationTimestamp // Preenche automaticamente com o timestamp atual quando a entidade é criada.
    private LocalDateTime createdAt; // Data e hora de criação da empresa.
}
