package net.ssraju.fullstack.consumer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER =  LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId = "my-Wikimedia-CG"
    )
    public void consume(String eventMessage) {
        LOGGER.info(" Message Received : {}", eventMessage);
    }

}
