package rabbitmq.tutorial;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RabbitAmqpTutorialsRunner implements CommandLineRunner {
    @Value("${tutorial.client.duration:0}")
    int duration;

    ConfigurableApplicationContext context;

    public RabbitAmqpTutorialsRunner(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ready... running for " + duration + "ms");
        Thread.sleep(duration);
        context.close();
    }
}
