package br.com.igor.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.gestao_vagas.modules.candidate.Services.CreateCandidateService;
import br.com.igor.gestao_vagas.modules.candidate.entities.CandidateEntity;
// import br.com.igor.gestao_vagas.modules.candidate.CandidateRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

// import java.util.List;


@RestController
@RequestMapping("/candidate")
public class CondidateController {

   //  @Autowired
   //  private CandidateRepository candidateRepository;

   @Autowired
   private CreateCandidateService createCandidateService;

   @GetMapping("/get")
   public String TesteDaApi() {
      return "testando a APIs: teste funcionando corretamente";
   }
   
   @PostMapping("/create")
   public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity){
      try {
         var result = this.createCandidateService.execute(candidateEntity);
         return ResponseEntity.ok().body(result);
      } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }

   // @PostMapping("/CreateListUsers")
   // public List<CandidateEntity> createList(@Valid @RequestBody List<CandidateEntity> candidates){
   //    try {
   //       var result = this.createCandidateService.execute(candidates);
   //       return ResponseEntity.ok().body(result);
   //    } catch (Exception e) {
   //       
   //    }
   // }

   //  @PostMapping("/create")
   //  public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity){
   //    this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail()).ifPresent((user) -> {
   //       throw new UserFoundException();
   //    });

   //    return this.candidateRepository.save(candidateEntity);
   //  }
   

    // @PostMapping("/create")
    // public void create(@Valid @RequestBody CandidateEntity candidateEntity){
    //     System.out.println("candidato");
    //     System.out.println(candidateEntity.getEmail());
    // }
}
