package com.kipper.emailservice.core.exceptions;

import com.amazonaws.services.simpleemail.model.AmazonSimpleEmailServiceException;

public class EmailServiceExcepetion extends RuntimeException {

    /**
     * Construtores da classe
     *
     * @param message
     * @param e
     */
    public EmailServiceExcepetion(String message, AmazonSimpleEmailServiceException e) {
        super(message);
    }

    private EmailServiceExcepetion(String message, Throwable cause){
        super(message, cause);
    }
}
