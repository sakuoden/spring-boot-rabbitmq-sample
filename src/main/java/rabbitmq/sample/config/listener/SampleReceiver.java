package rabbitmq.sample.config.listener;

import org.springframework.stereotype.Component;

@Component
public class SampleReceiver {
    public void receiveMessage(String message) {
        System.out.println("Received: 「%s」".formatted(message));
    }
}
