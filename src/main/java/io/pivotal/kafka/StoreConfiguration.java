package io.pivotal.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.pivotal.kafka.data.MessageStore;

@Configuration
public class StoreConfiguration {

    @Bean
    public MessageStore testQueueStore() {
        MessageStore store = new MessageStore();
        store.setCapacity(250);
        return store;
    }
}