import models.Message;
import models.Subscriber;

public class SubscriberOne implements Subscriber {
    @Override
    public void consume(Message message) {
        System.out.println("Consuming Message: " + message.getMessage());
    }
}
