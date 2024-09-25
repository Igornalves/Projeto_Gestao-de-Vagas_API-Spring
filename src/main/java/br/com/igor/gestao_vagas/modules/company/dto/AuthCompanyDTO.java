package br.com.igor.gestao_vagas.modules.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// Classe Data Transfer Object (DTO) que encapsula as informações necessárias para a autenticação de uma empresa.
@Data // Gera automaticamente os métodos getters, setters, toString, equals e
      // hashCode.
@AllArgsConstructor // Gera um construtor com todos os campos da classe.
public class AuthCompanyDTO {

    private String password; // Armazena a senha da empresa para autenticação.
    private String username; // Armazena o nome de usuário da empresa para autenticação.

}
