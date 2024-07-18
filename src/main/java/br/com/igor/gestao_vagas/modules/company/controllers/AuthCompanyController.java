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

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {

    @Autowired
    private AuthCompanyService authCompanyService;
    
    @PostMapping("/companys")
    public ResponseEntity<Object> create(@RequestBody AuthCompanyDTO authCompanyDTO){
        try {
            var result = this.authCompanyService.execute(authCompanyDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
