package rabbitmq.sample.config.listener;

import org.springframework.stereotype.Component;

@Component
public class SampleReceiver {
    public void receiveMessage(String message) {
        System.out.println("Received: ã%sã".formatted(message));
    }
}
