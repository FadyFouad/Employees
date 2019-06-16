package com.etateck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/****************************************************
 *** Created by Fady Fouad on 6/16/2019 at 21:14.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("\n-------------------------------Employees------------------------\n");

        Employee employee3 = new Employee("Fady3", 27);
        Employee employee1 = new Employee("Fady1", 23);
        Employee employee2 = new Employee("Fady2", 25);
        Employee employee4 = new Employee("Fady4", 31);
        Employee employee5 = new Employee("Fady5", 35);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        employees.sort(Comparator.comparing(Employee::getName));
        printListLambda(employees,"=========> 30th",employee -> employee.getAge()>30);
        printListLambda(employees,"=========> Less Than30",employee -> employee.getAge()<30);


//        employeeLis.forEach(e -> {
//            System.out.print(e.getName());
//            System.out.println(" : "+e.getAge());
//        });


//        for (Employee employee :
//                employeeLis) {
//            if (employee.getAge() > 30){
//                System.out.println(employee.getName());
//            }
//        }


    }
    private static void printListLambda(List<Employee>employees, String age, Predicate<Employee>ageCondition){
        boolean print = true;
        if (print) {
            System.out.println(age);
            for (Employee employee :
                    employees) {
                if (ageCondition.test(employee))
                    System.out.println(employee.getName());
                }

//            System.out.println("--------------------Less Than 30---------------------");
//            employees.forEach(employee -> {
//                if (employee.getAge() < 30) {
//                    System.out.println(employee.getName());
//                }
//            });
        }
    }
}