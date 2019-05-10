package io.pivotal.kafka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.kafka.data.MessageObject;
import io.pivotal.kafka.data.MessageStore;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    private MessageStore testQueueStore;

    @GetMapping("/pull/{queueName}")
    public List<MessageObject> pullFromQueue(@PathVariable String queueName) {
        System.out.println("kafkacontroller::pullFromQueue called for queue: " + queueName);
        System.out.println("testqueue capacity: " + testQueueStore.getCapacity());
        return testQueueStore.getAllMessages();
    }

    public String index(Model model) {
        return "index";
    }
}
