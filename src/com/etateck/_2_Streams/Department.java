package com.etateck._2_Streams;

import com.etateck.Employee;

import java.util.ArrayList;
import java.util.List;

/****************************************************
 *** Created by Fady Fouad on 6/19/2019 at 16:22.***
 ***************************************************/
class Department {

    private List<Employee> employees;
    private String name;

    Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    void addEmployee(Employee employee) {
        employees.add(employee);
    }

    List<Employee> getEmployees() {
        return employees;
    }

    String getName() {
        return name;
    }
}