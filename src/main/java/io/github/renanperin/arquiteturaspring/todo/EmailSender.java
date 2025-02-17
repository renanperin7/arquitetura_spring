package io.github.renanperin.arquiteturaspring.todo;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    public void enviar(String message) {
        System.out.println("Enviado email: " + message);
    }
}
