package com.kipper.emailservice.core;

public interface EmailSenderUseCase {

    /**
     * Receberemos um contratro que vai dizer o
     * comportamento da nossa aplicação
     * Vai ter um metodo send email, ele vai receber algumas strings
     * to, subject e o body que é o corpo do email
     * Void pois não teremos retorno
     */
    void sendEmail(String to, String subject, String body);
}
