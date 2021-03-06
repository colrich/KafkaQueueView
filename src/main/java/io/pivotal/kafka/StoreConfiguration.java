package io.pivotal.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.pivotal.kafka.data.EnrichedPageviewObject;
import io.pivotal.kafka.data.InMemoryStore;
import io.pivotal.kafka.data.MessageObject;
import io.pivotal.kafka.data.PageviewObject;
import io.pivotal.kafka.data.UserObject;

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

    @Bean
    public InMemoryStore<EnrichedPageviewObject> enrichedPageviewQueueStore() {
        InMemoryStore<EnrichedPageviewObject> imm = new InMemoryStore<>(EnrichedPageviewObject.class);
        imm.setCapacity(250);
        return imm;
    }

    @Bean
    public InMemoryStore<UserObject> usersQueueStore() {
        InMemoryStore<UserObject> imm = new InMemoryStore<>(UserObject.class);
        imm.setCapacity(250);
        return imm;
    }

}