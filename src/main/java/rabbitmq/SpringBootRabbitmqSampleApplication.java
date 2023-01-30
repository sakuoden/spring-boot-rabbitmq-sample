package rabbitmq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import rabbitmq.tutorial.RabbitAmqpTutorialsRunner;

@SpringBootApplication
@EnableScheduling
public class SpringBootRabbitmqSampleApplication {
    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return args -> {
            System.out.println("This app uses Spring Profiles to control its behavior.\n");
            System.out.println("Sample usage: java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
        };
    }

    @Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial(RabbitAmqpTutorialsRunner rabbitAmqpTutorialsRunner) {
        return rabbitAmqpTutorialsRunner;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitmqSampleApplication.class, args);
    }

}
