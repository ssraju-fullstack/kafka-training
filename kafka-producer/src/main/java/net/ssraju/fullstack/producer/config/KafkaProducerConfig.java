package net.ssraju.fullstack.producer.config;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import net.ssraju.fullstack.producer.handler.WikimediaChangeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class KafkaProducerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerConfig.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerConfig(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {

        String topic = "wikimedia_recentchange";
        String wikimediaUrl = "https://stream.wikimedia.org/v2/stream/recentchange";

        //To read real time events from wikimedia

        EventHandler eventHandler = new WikimediaChangeHandler(kafkaTemplate, topic);

        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(wikimediaUrl));
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(5);
    }
}
