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

// Anotação que indica que esta classe é um controlador REST
// para gerenciar operações relacionadas a candidatos.
@RestController
@RequestMapping("/candidate") // Define a rota base para os endpoints deste controlador.
public class CondidateController {

   //  @Autowired // Injeção de dependência para o serviço que cria candidatos.
   //  private CandidateRepository candidateRepository;

   @Autowired // Injeção de dependência para o serviço que cria candidatos.
   private CreateCandidateService createCandidateService;

   // Endpoint GET para testar a API. Retorna uma mensagem simples.
   @GetMapping("/get")
   public String TesteDaApi() {
      return "testando a APIs: teste funcionando corretamente";
   }
   
   // Endpoint POST para criar um novo candidato. A entrada é validada
   // e o objeto CandidateEntity é recebido no corpo da requisição.
   @PostMapping("/create")
   public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity){
      try {
         // Chama o serviço para executar a criação do candidato.
         var result = this.createCandidateService.execute(candidateEntity);
         // Retorna uma resposta HTTP 200 (OK) com o resultado da operação.
         return ResponseEntity.ok().body(result);
      } catch (Exception e) {
         // Retorna uma resposta HTTP 400 (BAD REQUEST) em caso de erro
         // com a mensagem de erro.
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }

   // Métodos comentados que podem ser usados no futuro para
   // criar listas de candidatos ou implementar outras funcionalidades.
   // @PostMapping("/CreateListUsers")
   // public List<CandidateEntity> createList(@Valid @RequestBody List<CandidateEntity> candidates){
   //    try {
   //       var result = this.createCandidateService.execute(candidates);
   //       return ResponseEntity.ok().body(result);
   //    } catch (Exception e) {
   //       // Tratar exceção
   //    }
   // }


   // Exemplo de um método comentado que poderia ser usado para
   // verificar se um usuário já existe antes de criar um novo.
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
