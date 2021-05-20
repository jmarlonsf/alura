package br.com.alura.loja.exception;

public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }
}
