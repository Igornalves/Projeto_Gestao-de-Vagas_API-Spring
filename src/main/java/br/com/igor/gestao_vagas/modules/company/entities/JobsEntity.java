package br.com.igor.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp; // Anotação para gerar automaticamente o timestamp de criação.

import jakarta.persistence.Column; // Anotação para mapear atributos para colunas no banco de dados.
import jakarta.persistence.Entity; // Anotação para indicar que a classe é uma entidade JPA.
import jakarta.persistence.GeneratedValue; // Anotação para gerar automaticamente o valor da chave primária.
import jakarta.persistence.GenerationType; // Estratégia de geração de valores para a chave primária.
import jakarta.persistence.Id; // Anotação para indicar o campo da chave primária.
import jakarta.persistence.JoinColumn; // Anotação para especificar a coluna de junção com outra entidade.
import jakarta.persistence.ManyToOne; // Anotação para definir o relacionamento muitos-para-um.
import jakarta.validation.constraints.NotBlank; // Anotação para validar que o campo não deve estar em branco.
import lombok.Data; // Anotação Lombok para gerar automaticamente métodos comuns.

@Entity(name = "jobs") // Define que esta classe será mapeada para a tabela "jobs".
@Data // Gera automaticamente os métodos getters, setters, toString, equals e
      // hashCode.
public class JobsEntity {

    @Id // Indica que este campo é a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.UUID) // Gera um UUID automaticamente para cada nova instância.
    private UUID id; // Identificador único do trabalho.

    private String description; // Descrição do trabalho.
    private String benefits; // Benefícios associados ao trabalho.

    @NotBlank(message = "Este campo e obrigatorio") // Valida que o nível não pode estar em branco.
    private String level; // Nível do trabalho (ex: Júnior, Pleno, Sênior).

    @ManyToOne() // Define um relacionamento muitos-para-um com a entidade CompanyEntity.
    @JoinColumn(name = "company_id", insertable = false, updatable = false) // Especifica a coluna que representa a
                                                                            // chave estrangeira.
    private CompanyEntity companyEntity; // Referência à entidade da empresa associada ao trabalho.

    @Column(name = "company_id", nullable = false) // Mapeia a coluna que contém o ID da empresa, que não pode ser nulo.
    private UUID companyId; // Identificador único da empresa associada ao trabalho.

    @CreationTimestamp // Preenche automaticamente com o timestamp atual quando a entidade é criada.
    private LocalDateTime createdAt; // Data e hora de criação do trabalho.

}
