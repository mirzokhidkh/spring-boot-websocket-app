package uz.mk.springbootwebsocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestComponent {

    private final SimpMessagingTemplate messagingTemplate;


    public TestComponent(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Scheduled(fixedRate = 5000L)
    public void getDate() {
        Date date = new Date();
        messagingTemplate.convertAndSend("/topic/date", date);
    }

    public void typing(String message) {
        messagingTemplate.convertAndSend("/topic/type", message);
    }

    public void keydown(String message) {
//        System.out.println("keydown message in TestComponent " + message);
        messagingTemplate.convertAndSend("/topic/keydown", message);
    }

}
