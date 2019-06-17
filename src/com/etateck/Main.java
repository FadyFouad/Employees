package com.etateck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/****************************************************
 *** Created by Fady Fouad on 6/16/2019 at 21:14.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("\n-------------------------------Employees------------------------\n");

        Employee employee3 = new Employee("Fady3 3_LastName", 27);
        Employee employee1 = new Employee("Fady1 1_LastName", 23);
        Employee employee2 = new Employee("Fady2 2_LastName", 25);
        Employee employee4 = new Employee("Fady4 4_LastName", 31);
        Employee employee5 = new Employee("Fady5 5_LastName", 35);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        employees.sort(Comparator.comparing(Employee::getName));
        printListLambda(employees,"=========> 30th",employee -> employee.getAge()>30);
        printListLambda(employees,"=========> Less Than30",employee -> employee.getAge()<30);

        IntPredicate intPredicate = value -> value>10;
        IntPredicate intPredicate1 = value -> value<20;
        System.out.println("----------------------------------");
        System.out.println(intPredicate.and(intPredicate1).test(15));

//        int index = 0;
        employees.forEach(employee->{
            String[] name = employee.getName().split(" ");
            String firstName=name[0];
            String lastName = employee.getName().substring(employee.getName().indexOf(' ')+1);
            Function<Employee,String>stringFunction = e ->
                    e.getName().substring(e.getName().indexOf(' ')+1);
            String s = stringFunction.apply(employees.get(employees.indexOf(employee)));
            System.out.println("Last Name Of "+firstName +" is "+s);
        });
    }
    private static void printListLambda(List<Employee>employees, String age, Predicate<Employee>ageCondition){

            System.out.println(age);
            employees.forEach(employee -> {
                if (ageCondition.test(employee))
                    System.out.println(employee.getName());
            });

    }
}