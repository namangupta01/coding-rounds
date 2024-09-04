package models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Topic {
    private String name;
    private ArrayList<Message> messages;

    public Topic(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
    }

    public void addMessages(Message message) {
        this.messages.add(message);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Message> getMessages() {
        return this.messages;
    }
}
