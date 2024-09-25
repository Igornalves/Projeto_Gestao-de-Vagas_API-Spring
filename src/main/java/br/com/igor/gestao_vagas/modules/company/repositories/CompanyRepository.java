package br.com.igor.gestao_vagas.modules.company.repositories;

import java.util.Optional; // Importa a classe Optional para tratar valores que podem ser nulos.
import java.util.UUID; // Importa a classe UUID para identificação única.

import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository para operações de banco de dados.

import br.com.igor.gestao_vagas.modules.company.entities.CompanyEntity; // Importa a entidade CompanyEntity.

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    // Método para buscar uma empresa pelo nome de usuário ou email. Retorna um
    // Optional para lidar com possíveis valores nulos.
    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);

    // Método para buscar uma empresa pelo nome de usuário. Retorna um Optional para
    // valores que podem não existir.
    Optional<CompanyEntity> findByUsername(String username);
}
