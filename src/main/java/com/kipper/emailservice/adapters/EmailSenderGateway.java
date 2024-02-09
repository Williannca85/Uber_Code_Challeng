package com.kipper.emailservice.adapters;

public interface EmailSenderGateway {
    /**
     * Teremos um metodo void que também vai ter o nome de sendEmail
     * Qual é a diferença desse void para o da application?
     * O da Core representa a logica de negocio, ela é agnostico a implentação
     * e infraestrutura
     * Já a do adapters representa um contrato para que a aplicação intereja com
     * os serviços de fora
     */
    void sendEmail(String to, String subject, String body);
}
