package rabbitmq.config.listener;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitmq.config.queue.SampleQueueConfig;

@Configuration
public class SampleReceiverConfig {
    @Bean
    MessageListenerAdapter listenerAdapter(SampleReceiver sampleReceiver) {
        return new MessageListenerAdapter(sampleReceiver, "receiveMessage");
    }

    @Bean
    SimpleMessageListenerContainer container(
        ConnectionFactory connectionFactory,
        MessageListenerAdapter listenerAdapter
    ) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(SampleQueueConfig.queueName);
        container.setMessageListener(listenerAdapter);

        return container;
    }
}
