package root.iv.fanorona.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import root.iv.fanorona.data.message.Message;

@Controller
public class ChatController {

    @SendTo("/chat/message")
    @MessageMapping("/message")
    public Message getMessage(Message message) {
        System.out.println(message);
        return message;
    }
}
