package services;

import exceptions.TopicNotFoundException;
import models.Message;
import models.Subscriber;
import models.Topic;
import workers.SubscriberWorker;

import java.util.HashMap;

public class PublisherService {
    HashMap<String, TopicHandler> topicToTopicHandler;
    private HashMap<Subscriber, SubscriberWorker> subscriberToSubscriberWorkerMap = new HashMap<>();

    public PublisherService() {
        topicToTopicHandler = new HashMap<String, TopicHandler>();
        this.subscriberToSubscriberWorkerMap = new HashMap<>();
    }

    public void createTopic(String name) {
        Topic topic =  new Topic(name);
        TopicHandler topicHandler = new TopicHandler(topic, this);
        topicToTopicHandler.put(name, topicHandler);
    }

    public void subscribeToTopic(String name, Subscriber subscriber) {
        TopicHandler topicHandler = topicToTopicHandler.get(name);
        topicHandler.addSubscribers(subscriber);
        SubscriberWorker subscriberWorker = new SubscriberWorker(subscriber, topicHandler);
        this.getSubscriberToSubscriberWorkerMap().put(subscriber, subscriberWorker);
    }

    public void publish(String topicName, Message message) throws TopicNotFoundException {
        if(!this.topicToTopicHandler.containsKey(topicName)) throw new TopicNotFoundException();
        TopicHandler topicHandler = this.topicToTopicHandler.get(topicName);
        topicHandler.addMessage(message);
//        startPublishingToSubscribers(topicHandler);
    }

    public void resetOffsetOfSubscriber(Subscriber subscriber, int offset) {
        this.subscriberToSubscriberWorkerMap.get(subscriber).resetOffset(offset);
        this.subscriberToSubscriberWorkerMap.get(subscriber).getTopicHandler();
    }


    public HashMap<Subscriber, SubscriberWorker> getSubscriberToSubscriberWorkerMap() {
        return subscriberToSubscriberWorkerMap;
    }

    public void setSubscriberToSubscriberWorkerMap(HashMap<Subscriber, SubscriberWorker> subscriberToSubscriberWorkerMap) {
        this.subscriberToSubscriberWorkerMap = subscriberToSubscriberWorkerMap;
    }
}
















