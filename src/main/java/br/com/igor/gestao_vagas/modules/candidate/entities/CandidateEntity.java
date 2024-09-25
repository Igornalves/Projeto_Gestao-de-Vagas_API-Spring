package br.com.igor.gestao_vagas.modules.candidate.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

// Classe que representa uma entidade de candidato no sistema.
// A anotação @Data do Lombok gera automaticamente métodos como getters, setters, equals, hashCode e toString.
@Data
@Entity(name = "candidate") // Define que esta classe é uma entidade JPA e mapeia para a tabela "candidate".
public class CandidateEntity {
    
    @Id // Indica que este campo é a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.UUID) // Define que o ID será gerado automaticamente como um UUID.
    private UUID id;

    // Nome do candidato. O campo é um String sem restrições específicas.
    // @Column(name = "nome") // Anotação comentada que poderia ser usada para personalizar o nome da coluna no banco de dados.
    private String name;

    // Nome de usuário do candidato, que não deve conter espaços.
    @Pattern(regexp = "\\S+", message = "O campo [username] nao deve conter espaco")
    private String username;

    // Endereço de e-mail do candidato, que deve ser válido.
    @Email(message = "o campo deve conter um e-mail valido")
    private String email;

    // Senha do candidato, que deve ter entre 10 e 100 caracteres.
    @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
    private String password;

    // Descrição do candidato, que pode incluir informações adicionais.
    private String description;
    // Campo para armazenar o currículo do candidato, possivelmente como um link ou texto.
    private String curriculum;

    // Data e hora em que o candidato foi criado, que é preenchida automaticamente pelo Hibernate.
    @CreationTimestamp // Anotação que indica que este campo deve ser preenchido com o timestamp da criação. 
    private LocalDateTime createdAt;

}
