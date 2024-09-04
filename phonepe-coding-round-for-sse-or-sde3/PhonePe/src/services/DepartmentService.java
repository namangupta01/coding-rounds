package services;

import models.Department;

import java.util.HashMap;
import java.util.HashSet;

public class DepartmentService {
    private static DepartmentService departmentServiceInstance = null;
    private HashMap<String, Department> departments;

    private DepartmentService() {
        this.departments = new HashMap<>();
    }

    public Department getOrCreateDepartment(String departmentName) {
        if(!this.departments.containsKey(departmentName)) {
            this.departments.put(departmentName, new Department(departmentName));
        }
        return this.departments.get(departmentName);
    }

    public static DepartmentService getInstance() {
        if(departmentServiceInstance == null) {
            departmentServiceInstance = new DepartmentService();
        }
        return departmentServiceInstance;
    }
}
