package org.example.Exceptions;

public class CommandeInvalideException extends RuntimeException {
    public CommandeInvalideException(String message) {
        super(message);
    }
}
