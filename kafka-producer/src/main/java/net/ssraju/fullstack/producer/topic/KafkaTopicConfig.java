package net.ssraju.fullstack.producer.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic  newKafkaTopic() {
        return TopicBuilder.name("wikimedia_recentchange")
                .build();
    }

}
