package br.com.fiap.chat.chat;

import lombok.Getter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class ChatMessageReceiver {
    private final List<String> messages = new ArrayList<>();

    @RabbitListener(queues = "chat-queue")
    public void enviarmensagem(String message) {
        messages.add(message);
    }
}