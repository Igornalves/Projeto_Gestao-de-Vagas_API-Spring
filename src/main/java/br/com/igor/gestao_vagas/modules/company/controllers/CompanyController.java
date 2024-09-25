package br.com.igor.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.igor.gestao_vagas.modules.company.services.CreateCompanyService;
import jakarta.validation.Valid;

// Controlador REST responsável pela manipulação de requisições relacionadas a empresas.
@RestController
@RequestMapping("/company") // Define a rota base para as operações relacionadas a empresas.
public class CompanyController {

    // Injeção de dependência do serviço de criação de empresas.
    @Autowired
    private CreateCompanyService companyService;

    // Método que manipula requisições POST para criar uma nova empresa.
    @PostMapping("/create") // Define a rota específica para a criação de empresas.
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            // Chama o serviço para executar a lógica de criação e obtém o resultado.
            var result = this.companyService.execute(companyEntity);
            return ResponseEntity.ok().body(result); // Retorna o resultado com status HTTP 200 (OK).
        } catch (Exception e) {
            e.printStackTrace(); // Imprime o stack trace da exceção no console para depuração.
            return ResponseEntity.badRequest().body(e.getMessage()); // Retorna uma resposta com status HTTP 400 (Bad
                                                                     // Request) e a mensagem de erro.
        }
    }
}
