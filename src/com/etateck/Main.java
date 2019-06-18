package com.etateck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

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
        printListLambda(employees, "=========> 30th", employee -> employee.getAge() > 30);
        printListLambda(employees, "=========> Less Than30", employee -> employee.getAge() < 30);

        IntPredicate intPredicate = value -> value > 10;
        IntPredicate intPredicate1 = value -> value < 20;
        System.out.println("----------------------------------");
        System.out.println(intPredicate.and(intPredicate1).test(15));

//        int index = 0;
        employees.forEach(employee -> {
            String[] name = employee.getName().split(" ");
            String firstName = name[0];
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            Function<Employee, String> stringFunction = e ->
                    e.getName().substring(e.getName().indexOf(' ') + 1);
            String s = stringFunction.apply(employees.get(employees.indexOf(employee)));
            System.out.println("Last Name Of " + firstName + " is " + s);//s = lastName
        });
        System.out.println("*****************************************************");

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> getFirstName = name -> name.substring(0, name.indexOf(' '));
        Function<String, String> getLastName = name -> name.substring(name.indexOf(' ')+1);
        Function chainFunction = upperCase.andThen(getFirstName);


        System.out.println(chainFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> getUpperAge = (name, employee) -> name.concat(" " + employee.getAge());
        String upperName = upperCase.apply(employees.get(0));
        System.out.println(getUpperAge.apply(upperName,employee1));

        IntUnaryOperator incByFive = i->i+5;
        System.out.println(incByFive.applyAsInt(15));

        Consumer<String>consumer1 = s-> s.toUpperCase();
        Consumer<String>consumer2 = s-> System.out.println(s);
        consumer1.andThen(consumer2).accept("Hello");//No consumer1
    }

    private static void printListLambda(List<Employee> employees, String age, Predicate<Employee> ageCondition) {

        System.out.println(age);
        employees.forEach(employee -> {
            if (ageCondition.test(employee))
                System.out.println(employee.getName());
        });

    }
}