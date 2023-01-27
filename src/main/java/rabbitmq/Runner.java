package rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rabbitmq.config.queue.SampleQueueConfig;

@Component
public class Runner implements CommandLineRunner {
    RabbitTemplate rabbitTemplate;

    Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=====================");

        rabbitTemplate.convertAndSend(
            SampleQueueConfig.exchangeName,
            "sample.foo",
            "RabbitTemplateから送信したメッセージです"
        );

        rabbitTemplate.convertAndSend(
            SampleQueueConfig.exchangeName,
            "sample",
            "別のルーティングキーからのメッセージです"
        );

        System.out.println("======================");
    }
}
