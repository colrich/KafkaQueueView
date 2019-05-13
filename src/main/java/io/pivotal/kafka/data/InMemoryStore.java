package io.pivotal.kafka.data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryStore<T> {

    private Class<T> cl;

    private List<T> messages;
    private int maxCapacity;

    public InMemoryStore(Class<T> cl) {
        this.cl = cl;
        maxCapacity = 100;
        messages = new ArrayList<>();
    }

    public void setCapacity(int capacity) { this.maxCapacity = capacity; }
    public int getCapacity() { return maxCapacity; }

    public void addMessage(T message) {
        synchronized(messages) {
            messages.add(0, message);
            if (messages.size() > maxCapacity) {
                System.out.println("MessageStore::addMessage: pruning msg at index: " + (maxCapacity-1));
                messages.remove(maxCapacity-1);
            }
        }
    }

    public T getMessage(int index) {
        if (messages.size() > index) return messages.get(index);
        else return null;
    }

    public List<T> getAllMessages() {
        if (messages.size() == 0) return new ArrayList<T>();

        List<T> msgs;
        synchronized(messages) {
            @SuppressWarnings("unchecked")
            T[] mos = (T[])Array.newInstance(cl, messages.size());
            messages.toArray(mos);
            System.out.println("MessageStore::getAllMessages: converted messages to array: " + mos.length);
            msgs = Arrays.asList(mos);
            System.out.println("MessageStore::getAllMessages: converted array to list: " + msgs.size());
        }
        return msgs;
    }
}