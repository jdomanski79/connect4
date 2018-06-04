package pl.jdomanski.connect4;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class Connect4Controller {
    
    
    @MessageMapping("/hello")
    @SendTo("/topic/game")
    public String game(String message) {
        return message;
        
    }
}
