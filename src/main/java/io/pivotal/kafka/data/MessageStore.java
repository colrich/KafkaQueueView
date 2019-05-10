package io.pivotal.kafka.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStore {

    private List<MessageObject> messages;
    private int maxCapacity;

    public MessageStore() {
        maxCapacity = 100;
        messages = new ArrayList<>();
    }

    public void setCapacity(int capacity) { this.maxCapacity = capacity; }
    public int getCapacity() { return maxCapacity; }

    public void addMessage(MessageObject message) {
        synchronized(messages) {
            messages.add(0, message);
            if (messages.size() > maxCapacity) {
                System.out.println("MessageStore::addMessage: pruning msg at index: " + (maxCapacity-1));
                messages.remove(maxCapacity-1);
            }
        }
    }

    public MessageObject getMessage(int index) {
        if (messages.size() > index) return messages.get(index);
        else return new MessageObject("no message at that index");
    }

    public List<MessageObject> getAllMessages() {
        if (messages.size() == 0) return new ArrayList<MessageObject>();

        List<MessageObject> msgs;
        synchronized(messages) {
            MessageObject[] mos = new MessageObject[messages.size()];
            messages.toArray(mos);
            System.out.println("MessageStore::getAllMessages: converted messages to array: " + mos.length);
            msgs = Arrays.asList(mos);
            System.out.println("MessageStore::getAllMessages: converted array to list: " + msgs.size());
//            messages.clear();
            System.out.println("MessageStore::getAllMessages: cleared message list: " + messages.size());
        }
        return msgs;
    }

}