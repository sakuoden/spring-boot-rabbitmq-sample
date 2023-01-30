package rabbitmq.tutorial.tutorial1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class Tutorial1Receiver {
    @RabbitHandler
    public void receive(String in) {
        System.out.println("[x] Received '" + in + "'");
    }
}