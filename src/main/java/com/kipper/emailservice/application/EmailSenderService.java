package com.kipper.emailservice.application;

import com.kipper.emailservice.adapters.EmailSenderGateway;
import com.kipper.emailservice.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Temos que adicionar o @Service para o Spring entender que deve
 * fazer as injeções das dependencias
 */
@Service
public class EmailSenderService implements EmailSenderUseCase {

    /**
     * Ela vai implementar o core na nossa aplicação
     * Não vai ser nessa camada ainda que iremos chamar a SDK da
     * AWS
     * Dependencia Gateway vai ser a porta de entrada que vai receber via
     * construtor Autowired
     * Ele depende de um EmailSenderGateway
     */

    private final EmailSenderGateway emailSerderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailGateway){
        this.emailSerderGateway = emailGateway;
    }
    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSerderGateway.sendEmail(to, subject, body);
    }


}
