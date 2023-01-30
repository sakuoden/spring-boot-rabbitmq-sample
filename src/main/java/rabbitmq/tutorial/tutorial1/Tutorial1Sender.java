package rabbitmq.tutorial.tutorial1;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tutorial1Sender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World";
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("[x] Sent '" + message + "'");
    }
}
