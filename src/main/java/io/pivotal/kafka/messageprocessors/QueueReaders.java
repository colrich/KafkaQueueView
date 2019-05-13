package io.pivotal.kafka.messageprocessors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import io.pivotal.kafka.data.InMemoryStore;
import io.pivotal.kafka.data.MessageObject;

@Component
public class QueueReaders {

    @Autowired
    private InMemoryStore<MessageObject> testQueueStore;

    @KafkaListener(topics="testx")
    public void onMessageTestQueue(String content) {
        System.out.println("QueueReaders::onMessageTestQueue: called with content: " + content);
        System.out.println("QueueReaders::onMessageTestQueue: available store capacity: " + testQueueStore.getCapacity());
        testQueueStore.addMessage(new MessageObject(content));
    }
}