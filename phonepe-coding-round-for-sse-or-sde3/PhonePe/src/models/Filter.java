package models;

public class Filter<T> {

    private String name;
    private T value;

    public Filter(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }
}
