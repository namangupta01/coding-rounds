package services;

import models.Department;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static UserService userServiceInstance = null;

    private List<User>  users;

    private UserService() {
        this.users = new ArrayList<>();
    }

    public static UserService getInstance() {
        if(userServiceInstance == null) {
            userServiceInstance = new UserService();
        }
        return userServiceInstance;
    }

    public User addUser(String name, String departmentName) {
        Department department = DepartmentService.getInstance().getOrCreateDepartment(departmentName);
        User user = new User(name, department);
        this.users.add(user);
        return user;
    }
}
