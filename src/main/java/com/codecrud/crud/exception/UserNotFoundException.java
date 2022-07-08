package com.codecrud.crud.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("l'utilisateur " + id + "n'existe pas");
    }
}
