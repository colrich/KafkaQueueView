package io.pivotal.kafka.messageprocessors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import io.pivotal.kafka.data.InMemoryStore;
import io.pivotal.kafka.data.MessageObject;
import io.pivotal.kafka.data.PageviewObject;
import io.pivotal.kafka.data.UserObject;

@Component
public class QueueReaders {

    @Autowired
    private InMemoryStore<MessageObject> testQueueStore;

    @Autowired
    private InMemoryStore<PageviewObject> pageviewQueueStore;

    @Autowired
    private InMemoryStore<UserObject> usersQueueStore;

    @KafkaListener(topics="testx")
    public void onMessageTestQueue(String content) {
        System.out.println("QueueReaders::onMessageTestQueue: called with content: " + content);
        System.out.println("QueueReaders::onMessageTestQueue: available store capacity: " + testQueueStore.getCapacity());
        testQueueStore.addMessage(new MessageObject(content));
    }

    @KafkaListener(topics="pageviewx")
    public void onMessagePageviewQueue(String content) {
        System.out.println("QueueReaders::onMessagePageviewQueue: called with content: " + content);
        System.out.println("QueueReaders::onMessagePageviewQueue: available store capacity: " + pageviewQueueStore.getCapacity());
        pageviewQueueStore.addMessage(PageviewObject.parse(content));
    }

    @KafkaListener(topics="usersx")
    public void onMessageUsersQueue(String content) {
        System.out.println("QueueReaders::onMessageUsersQueue: called with content: " + content);
        System.out.println("QueueReaders::onMessageUsersQueue: available store capacity: " + usersQueueStore.getCapacity());
        usersQueueStore.addMessage(UserObject.parse(content));
    }

}