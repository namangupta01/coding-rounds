import exceptions.TopicNotFoundException;
import models.Message;
import models.Subscriber;
import models.Topic;
import services.PublisherService;

public class Main {
    public static void main(String [] args) throws TopicNotFoundException {
        PublisherService publisherService = new PublisherService();

        publisherService.createTopic("topic1");
        Subscriber subscriber = new SubscriberOne();
        publisherService.subscribeToTopic("topic1", subscriber);
        Message message1 = new Message("message1");
        Message message2 = new Message("message2");
        Message message3 = new Message("message3");
        Message message4 = new Message("message4");
        publisherService.publish("topic1", message1);
        publisherService.publish("topic1", message2);
        publisherService.publish("topic1", message3);
        publisherService.resetOffsetOfSubscriber(subscriber, 1);
        publisherService.publish("topic1", message4);
    }
}
