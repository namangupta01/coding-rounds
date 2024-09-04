## Message Queue
We have to implement an in-memory message queue supporting publisher-subscriber model. It should support following operations:

* It should support multiple topics where messages can be published.
* Publisher should be able to publish a message to a particular topic.
* Subscribers should be able to subscribe to a topic at any time and should receive all the published messages in-order.
* Whenever a message is published to a topic, all the subscribers, who are subscribed to that topic, should receive the message.
* In the event, a subscriber joins back after having subscribed before, they should continue receiving messages starting from previous offset.
* An offset is the cursor till which a particular subscriber has received the messages.
* Subscribers should be able to run in parallel and should be able reset offset anytime.

// ayush.kumar@observe.ai