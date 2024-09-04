package workers;

import models.Message;
import models.Subscriber;
import services.TopicHandler;

import java.util.ArrayList;

public class SubscriberWorker implements Runnable {
    int offset;
    Subscriber subscriber;
    TopicHandler topicHandler;

    public SubscriberWorker(Subscriber subscriber, TopicHandler topicHandler) {
        this.offset = 0;
        this.subscriber = subscriber;
        this.topicHandler = topicHandler;
    }

    public void resetOffset(int offset) {
        System.out.println("Resetting offset" + offset);
        this.offset = offset;
    }

    public TopicHandler getTopicHandler() {
        return this.topicHandler;
    }

    @Override
    public void run() {
        synchronized (subscriber) {
            ArrayList<Message> messages = topicHandler.getTopic().getMessages();

            for(int i = offset; i< messages.size(); i++) {
                subscriber.consume(messages.get(i));
                offset++;
            }
        }
    }
}
