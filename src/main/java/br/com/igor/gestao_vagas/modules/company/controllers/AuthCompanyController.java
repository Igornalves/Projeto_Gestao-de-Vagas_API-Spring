package br.com.igor.gestao_vagas.modules.company.controllers;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import br.com.igor.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.igor.gestao_vagas.modules.company.services.AuthCompanyService;

// Controlador REST responsável pela autenticação das empresas.
// A anotação @RestController indica que esta classe é um controlador onde cada método retorna um objeto JSON.
@SuppressWarnings("unused")
@RestController
@RequestMapping("/auth") // Define a rota base para as requisições de autenticação.
public class AuthCompanyController {

    // Injeção de dependência do serviço de autenticação de empresas.
    @Autowired
    private AuthCompanyService authCompanyService;

    // Método que manipula requisições POST para criar uma nova autenticação de
    // empresa.
    @PostMapping("/companys") // Define a rota específica para a autenticação de empresas.
    public ResponseEntity<Object> create(@RequestBody AuthCompanyDTO authCompanyDTO) {
        try {
            // Chama o serviço para executar a lógica de autenticação e obtém o resultado.
            var result = this.authCompanyService.execute(authCompanyDTO);
            return ResponseEntity.ok().body(result); // Retorna o resultado com status HTTP 200 (OK).
        } catch (Exception e) {
            // Em caso de erro, retorna uma resposta com status HTTP 401 (Unauthorized) e a
            // mensagem de erro.
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
