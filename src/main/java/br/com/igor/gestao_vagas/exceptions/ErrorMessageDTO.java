package br.com.igor.gestao_vagas.exceptions;

// A classe ErrorMessageDTO é um Data Transfer Object (DTO) utilizado para
// encapsular informações sobre mensagens de erro que podem ocorrer na aplicação.
import lombok.AllArgsConstructor;
import lombok.Data;

// Anotação Lombok para gerar automaticamente os métodos getters, setters, 
// toString, equals e hashCode para os campos da classe.
@Data
// Anotação Lombok que gera um construtor com todos os parâmetros da classe.
@AllArgsConstructor
public class ErrorMessageDTO {

    // Mensagem de erro que descreve o problema encontrado.
    private String message;
    
    // O campo relacionado ao erro, que pode ajudar a identificar onde
    // o erro ocorreu na entrada de dados ou no processamento.
    private String field;
    
}
