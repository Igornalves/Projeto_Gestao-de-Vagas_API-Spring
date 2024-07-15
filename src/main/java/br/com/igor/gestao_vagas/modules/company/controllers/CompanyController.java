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

@RestController
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CreateCompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            var result = this.companyService.execute(companyEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
