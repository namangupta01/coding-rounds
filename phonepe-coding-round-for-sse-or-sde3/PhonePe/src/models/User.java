package models;

public class User {
    private String name;
    private Department department;

    public User(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }
}
