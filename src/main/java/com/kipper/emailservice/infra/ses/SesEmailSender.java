package com.kipper.emailservice.infra.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.kipper.emailservice.adapters.EmailSenderGateway;
import com.kipper.emailservice.core.exceptions.EmailServiceExcepetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Temos que adicionar o @Service para o Spring entender que deve
 * fazer as injeções das dependencias
 */
@Service
public class SesEmailSender implements EmailSenderGateway {


    /**
     * Agora teremos as dependencias do SDK da AWS
     *
     */
    private final AmazonSimpleEmailService amazonSimpleEmailService;

    /**
     *
     * @param amazonSimpleEmailService
     * Vai injetar atraves do construtor
     * Aqui eu dependo do EmailSenderService
     */
    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService){
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    /**
     *
     * @param to
     * @param subject
     * @param body
     * SendEmailRequest pertence a biblioteca da AWS
     * withSource: quem está enviando
     * withDestination: quem vai receber (to, que é o nosso paramento)
     */
    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("teste@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );
        /**
         *
         */

        try {
            this.amazonSimpleEmailService.sendEmail(request);
        }catch (AmazonSimpleEmailServiceException e){
            throw new EmailServiceExcepetion("Falha ao enviar o email", e);
        }
    }
}
