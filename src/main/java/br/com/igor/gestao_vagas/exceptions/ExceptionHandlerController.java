package br.com.igor.gestao_vagas.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

// Anotação que indica que esta classe é um controlador de exceções
// global, permitindo tratar exceções lançadas em toda a aplicação.
@ControllerAdvice
public class ExceptionHandlerController<MessageSouce> {

    // Fonte de mensagens para internacionalização, utilizada para obter
    // mensagens de erro localizadas.
    private MessageSource messageSource;

    // Construtor que recebe uma instância de MessageSource para
    // injeção de dependência.
    private ExceptionHandlerController(MessageSource message) {
        this.messageSource = message;
    }
    
    // Método que trata exceções do tipo MethodArgumentNotValidException,
    // que são lançadas quando a validação de argumentos falha.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        // Lista que armazena as mensagens de erro a serem retornadas.
        List<ErrorMessageDTO> dto = new ArrayList<>();

        // Itera sobre os erros de campo da exceção e cria um ErrorMessageDTO
        // para cada um, adicionando à lista de respostas.
        e.getBindingResult().getFieldErrors().forEach(err -> {
            // Obtém a mensagem de erro localizada com base na chave do erro
            // e no contexto de localidade atual.
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            // Cria um novo DTO de mensagem de erro com a mensagem e o campo
            // relacionado ao erro.
            ErrorMessageDTO error = new ErrorMessageDTO(message, err.getField());
            // Adiciona o DTO à lista.
            dto.add(error);
        });;

        // Retorna uma resposta com a lista de mensagens de erro e o status
        // HTTP 400 (BAD REQUEST).
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
