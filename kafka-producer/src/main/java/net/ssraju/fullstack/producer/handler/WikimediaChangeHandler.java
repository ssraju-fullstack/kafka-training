package net.ssraju.fullstack.producer.handler;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaChangeHandler implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangeHandler.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    public WikimediaChangeHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {
        // Do Nothing
    }

    @Override
    public void onClosed() throws Exception {
        // Do Nothing
    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("Event data --> %s", messageEvent.getData()));
        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {
         // Do Nothing
    }

    @Override
    public void onError(Throwable throwable) {
        // Do Nothing
    }

}
