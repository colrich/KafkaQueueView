package io.pivotal.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.pivotal.kafka.data.InMemoryStore;
import io.pivotal.kafka.data.MessageObject;
import io.pivotal.kafka.data.PageviewObject;

@Configuration
@Component
public class StoreConfiguration {

    @Bean
    public InMemoryStore<MessageObject> testQueueStore() {
        InMemoryStore<MessageObject> imm = new InMemoryStore<>(MessageObject.class);
        imm.setCapacity(250);
        return imm;
    }

    @Bean
    public InMemoryStore<PageviewObject> pageviewQueueStore() {
        InMemoryStore<PageviewObject> imm = new InMemoryStore<>(PageviewObject.class);
        imm.setCapacity(250);
        return imm;
    }


}