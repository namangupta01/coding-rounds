package services;

import models.Message;
import models.Subscriber;
import models.Topic;
import workers.SubscriberWorker;

import java.util.ArrayList;
import java.util.HashMap;

public class TopicHandler {

    private Topic topic;
    private ArrayList<Subscriber> subscribers;

    private PublisherService publisherService;
//    private HashMap<Subscriber, SubscriberWorker> subscriberToSubscriberWorkerMap = new HashMap<>();

    public TopicHandler(Topic topic, PublisherService publisherService) {
        this.topic = topic;
        this.subscribers = new ArrayList<>();
        this.publisherService = publisherService;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public ArrayList<Subscriber> getSubscribers() {
        return subscribers;
    }

    private void startPublishingToSubscribers() {
        for(int i=0; i<subscribers.size(); i++) {
            SubscriberWorker subscriberWorker = publisherService.getSubscriberToSubscriberWorkerMap().get(subscribers.get(i));
            (new Thread(subscriberWorker)).start();
        }
    }

    public void addMessage(Message message) {
        synchronized (this) {
            this.topic.addMessages(message);
            this.startPublishingToSubscribers();
        }
    }

    public void addSubscribers(Subscriber subscriber) {

        this.subscribers.add(subscriber);

    }


}










