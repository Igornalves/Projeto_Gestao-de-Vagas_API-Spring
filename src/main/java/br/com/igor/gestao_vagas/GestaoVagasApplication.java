package br.com.igor.gestao_vagas; // Pacote onde a aplicação está localizada.

import org.springframework.boot.SpringApplication; // Importa a classe para executar a aplicação Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa a anotação para configuração automática da aplicação.
// import org.springframework.context.annotation.ComponentScan; // Importa a anotação para escanear componentes em pacotes específicos.

@SpringBootApplication // Indica que esta é uma aplicação Spring Boot, habilitando a configuração automática.
// @ComponentScan(basePackages = "br.com.igor.gestao_vagas")
public class GestaoVagasApplication {
	public static void main(String[] args) {
		// Executa a aplicação Spring Boot.
		SpringApplication.run(GestaoVagasApplication.class, args);
	}
}
