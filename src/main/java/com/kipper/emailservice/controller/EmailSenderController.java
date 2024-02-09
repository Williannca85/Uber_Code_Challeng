package com.kipper.emailservice.controller;


import com.kipper.emailservice.application.EmailSenderService;
import com.kipper.emailservice.core.EmailRequest;
import com.kipper.emailservice.core.exceptions.EmailServiceExcepetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
    /**
     * Aqui teremos o emailSenderService para o disparo de email
     * Esse controller não depende do SesEmailService
     */
    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailService){
        this.emailSenderService = emailService;
    }

    /**
     * Vai retornar um Response Entity do tipo String
     * @return
     */
    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try {
          this.emailSenderService.sendEmail(request.to(), request.subject(),request.body());
          return ResponseEntity.ok("Email enviado com sucesso");
        } catch (EmailServiceExcepetion e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro no envio do email");
        }
    }
}
