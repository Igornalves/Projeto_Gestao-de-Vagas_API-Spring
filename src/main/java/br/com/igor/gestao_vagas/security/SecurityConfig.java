package br.com.igor.gestao_vagas.security;

import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependências.
import org.springframework.context.annotation.Bean; // Importa a anotação para definir beans.
import org.springframework.context.annotation.Configuration; // Importa a anotação para configurar classes de contexto.
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // Importa a classe para configuração de segurança HTTP.
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Importa o codificador de senha BCrypt.
import org.springframework.security.crypto.password.PasswordEncoder; // Importa a interface PasswordEncoder.
import org.springframework.security.web.SecurityFilterChain; // Importa a classe para o filtro de segurança.
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter; // Importa o filtro de autenticação básica.

@Configuration // Indica que esta classe contém configurações do Spring.
public class SecurityConfig {

    @Autowired // Injeção de dependência do filtro de segurança customizado.
    private SecurityFilter securityFilter;

    @Bean // Define um bean para a cadeia de filtros de segurança.
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Desabilita a proteção CSRF.
                .authorizeHttpRequests(auth -> {
                    // Define as permissões de acesso para as rotas
                    auth.requestMatchers("/candidate/get").permitAll() // Permite acesso sem autenticação.
                            .requestMatchers(HttpMethod.POST,"/company/create").permitAll() // Permite acesso sem autenticação.
                            .requestMatchers(HttpMethod.POST,"/candidate/create").permitAll() // Permite acesso sem autenticação.
                            .requestMatchers("/auth/companys").permitAll() // Permite acesso sem autenticação.
                            .requestMatchers("/swagger-ui/index.html").permitAll();

                    auth.anyRequest().authenticated(); // Exige autenticação para qualquer outra requisição.
                })
                .addFilterBefore(securityFilter, BasicAuthenticationFilter.class); // Adiciona o filtro de segurança customizado antes do filtro de autenticação básica.
        return http.build(); // Constrói e retorna a cadeia de filtros de segurança.
    }

    @Bean // Define um bean para o codificador de senhas.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Retorna uma instância do codificador BCrypt.
    }
}
