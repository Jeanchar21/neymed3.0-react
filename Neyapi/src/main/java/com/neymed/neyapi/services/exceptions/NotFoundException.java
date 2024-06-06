package com.neymed.neyapi.services.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(Object id) {
        super("Não há nenhum registro com o id: " + id);
    }
}
