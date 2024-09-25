package br.com.igor.gestao_vagas.exceptions;

// Classe personalizada de exceção que estende RuntimeException.
// Esta exceção é lançada quando um usuário já está cadastrado no sistema.
public class UserFoundException extends RuntimeException {
    // Construtor que chama o construtor da superclasse com uma mensagem
    // de erro padrão informando que o cadastro já existe.
    public UserFoundException(){
        super("Este Cadastro ja e existente no sistema");
    }
}
