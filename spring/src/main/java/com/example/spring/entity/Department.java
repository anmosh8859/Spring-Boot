package com.example.spring.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Department {
    public Department(String departmentName, String location) {
        this.departmentName = departmentName;
        this.location = location;
    }

    @Field(name="department_name")
    private String departmentName;
    private String location;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
