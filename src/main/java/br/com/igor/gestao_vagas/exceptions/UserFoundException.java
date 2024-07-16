package br.com.igor.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException(){
        super("Este Cadastro ja e existente no sistema");
    }
}
