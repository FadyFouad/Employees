package com.etateck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

        IntPredicate intPredicate = value -> value>10;
        IntPredicate intPredicate1 = value -> value<20;

        IntPredicate intPredicate_ = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value>10;
            }
        };
        IntPredicate intPredicate_1 = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value<20;
            }
        };

        System.out.println("----------------------------------");
        System.out.println(intPredicate.and(intPredicate1).test(15));
        System.out.println(intPredicate_.and(intPredicate_1).test(15));

//        Predicate<Employee> employeePredicate = new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getAge()<27;
//            }
//        };
//        printListLambda(employees,"-------------- age less than 27",employeePredicate);

//        System.out.println("---------------------------------------------");
//        Supplier<Integer>integerSupplier = ()-> new Random().nextInt(100);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(integerSupplier.get());
//        }
    }
    private static void printListLambda(List<Employee>employees, String age, Predicate<Employee>ageCondition){

            System.out.println(age);
            employees.forEach(employee -> {
                if (ageCondition.test(employee))
                    System.out.println(employee.getName());
            });

    }
}