package io.pivotal.kafka.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.kafka.data.EnrichedPageviewObject;
import io.pivotal.kafka.data.EnrichedPageviewVO;
import io.pivotal.kafka.data.InMemoryStore;
import io.pivotal.kafka.data.MessageObject;
import io.pivotal.kafka.data.MessageVO;
import io.pivotal.kafka.data.PageviewObject;
import io.pivotal.kafka.data.PageviewVO;
import io.pivotal.kafka.data.UserObject;
import io.pivotal.kafka.data.UserVO;
import io.pivotal.kafka.data.VO;

@RestController
@RequestMapping("kafka")
public class KafkaController {

//    @Autowired
//    private InMemoryStore<MessageObject> testQueueStore;

    @Autowired
    private InMemoryStore<PageviewObject> pageviewQueueStore;

    @Autowired
    private InMemoryStore<EnrichedPageviewObject> enrichedPageviewQueueStore;

    @Autowired
    private InMemoryStore<UserObject> usersQueueStore;

/*
    @GetMapping("/pull/{queueName}")
    public List<MessageVO> pullTestMessagesFromQueue(@PathVariable String queueName) {
        System.out.println("kafkacontroller::pullTestMessagesFromQueue called for queue: " + queueName);
        System.out.println("kafkacontroller::pullTestMessagesFromQueue store capacity: " + testQueueStore.getCapacity());

        List<MessageVO> msgs = new ArrayList<>();
        int index = 0;
        for (MessageObject mo : testQueueStore.getAllMessages()) {
            msgs.add(new MessageVO(index++, mo.getTestval()));
        }

        System.out.println("kafkacontroller::pullTestMessagesFromQueue constructed VO list of size: " + msgs.size());
        return msgs;
    }
*/

    @GetMapping("/pageviews/{queueName}")
    public List<? extends VO> pullPageviewsFromQueue(@PathVariable String queueName) {
        System.out.println("kafkacontroller::pullPageviewsFromQueue called for queue: " + queueName);
        System.out.println("kafkacontroller::pullPageviewsFromQueue queue store capacity: " + pageviewQueueStore.getCapacity());

        List<PageviewVO> msgs = new ArrayList<>();
        int index = 0;
        for (PageviewObject mo : pageviewQueueStore.getAllMessages()) {
            msgs.add(new PageviewVO(index++, mo));
        }

        System.out.println("kafkacontroller::pullPageviewsFromQueue constructed VO list of size: " + msgs.size());
        return msgs;
    }

    @GetMapping("/users/{queueName}")
    public List<? extends VO> pullUsersFromQueue(@PathVariable String queueName) {
        System.out.println("kafkacontroller::pullUsersFromQueue called for queue: " + queueName);
        System.out.println("kafkacontroller::pullUsersFromQueue queue store capacity: " + usersQueueStore.getCapacity());

        List<UserVO> msgs = new ArrayList<>();
        int index = 0;
        for (UserObject mo : usersQueueStore.getAllMessages()) {
            msgs.add(new UserVO(index++, mo));
        }

        System.out.println("kafkacontroller::pullUsersFromQueue constructed VO list of size: " + msgs.size());
        return msgs;
    }

    @GetMapping("/enriched/{queueName}")
    public List<? extends VO> pullEnrichedPageviewsFromQueue(@PathVariable String queueName) {
        System.out.println("kafkacontroller::pullEnrichedPageviewsFromQueue called for queue: " + queueName);
        System.out.println("kafkacontroller::pullEnrichedPageviewsFromQueue queue store capacity: " + enrichedPageviewQueueStore.getCapacity());

        List<EnrichedPageviewVO> msgs = new ArrayList<>();
        int index = 0;
        for (EnrichedPageviewObject mo : enrichedPageviewQueueStore.getAllMessages()) {
            msgs.add(new EnrichedPageviewVO(index++, mo));
        }

        System.out.println("kafkacontroller::pullEnrichedPageviewsFromQueue constructed VO list of size: " + msgs.size());
        return msgs;
    }

    public String index(Model model) {
        return "index";
    }
}
