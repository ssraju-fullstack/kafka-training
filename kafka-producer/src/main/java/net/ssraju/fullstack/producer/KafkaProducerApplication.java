package net.ssraju.fullstack.producer;

import net.ssraju.fullstack.producer.config.KafkaProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class);
    }

    @Autowired
    private KafkaProducerConfig kafkaProducerConfig;

    @Override
    public void run(String... args) throws Exception {
        kafkaProducerConfig.sendMessage();
    }
}
