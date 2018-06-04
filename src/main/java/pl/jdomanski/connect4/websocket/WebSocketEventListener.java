package pl.jdomanski.connect4.websocket;

import org.springframework.context.event.EventListener;
import org.springframework.web.socket.messaging.SessionConnectedEvent;


public class WebSocketEventListener {

    @EventListener
    public void handleWebSocketConnectListner (SessionConnectedEvent event){
        System.out.println(event);
    }
}
