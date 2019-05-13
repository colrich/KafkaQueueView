package io.pivotal.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.pivotal.kafka.data.InMemoryStore;
import io.pivotal.kafka.data.MessageObject;

@Configuration
@Component
public class StoreConfiguration {
/*
    @Bean
    public MessageStore testQueueStore() {
        MessageStore store = new MessageStore();
        store.setCapacity(250);
        return store;
    }
*/

    @Bean
    public InMemoryStore<MessageObject> testQueueStore() {
        System.out.println("****************** imm bean");
        InMemoryStore<MessageObject> imm = new InMemoryStore<MessageObject>(MessageObject.class);
        imm.setCapacity(250);
        return imm;
    }

}