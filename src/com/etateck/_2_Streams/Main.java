package com.etateck._2_Streams;

import com.etateck.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/****************************************************
 *** Created by Fady Fouad on 6/18/2019 at 21:16.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("\n---------------------Streams-----------------------------\n");

        List<String> nums = Arrays.asList(
                "A3", "A1", "A2", "a4",
                "B1", "B2", "B3",
                "C1", "C2", "C3",
                "D1", "D2", "D3",
                "E1", "E2", "E3");
        nums.stream()
                .map(String::toUpperCase)
//                .map(string->string.toUpperCase())
                .filter(s -> s.startsWith("A"))
                .sorted()
                .forEach(System.out::println);


        Employee fady1 = new Employee("Fady1", 22);
        Employee fady2 = new Employee("Fady2", 23);
        Employee fady3 = new Employee("Fady3", 24);
        Employee fady4 = new Employee("Fady4", 25);
        Employee fady5 = new Employee("Fady5", 26);

//        List<Employee>employees = new ArrayList<>();
//        employees.add(fady1);
//        employees.add(fady2);
//        employees.add(fady3);
//        employees.add(fady4);
//        employees.add(fady5);

        Department androidDev = new Department("Android Developer");
        androidDev.addEmployee(fady1);
        androidDev.addEmployee(fady2);
        androidDev.addEmployee(fady3);
        Department webDev = new Department("Web Developer");
        webDev.addEmployee(fady4);
        webDev.addEmployee(fady5);

        List<Department> departments = new ArrayList<>();
        departments.add(androidDev);
        departments.add(webDev);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("\n" + departments.get(0).getName() + "\n");

        nums.stream()
                .sorted()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
//        nums.forEach(s -> System.out.println(s));

//        Map<Integer, List<Employee>> listMap = departments.stream()
//                .flatMap(department -> department.getEmployees().stream())
//                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() > e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);
        System.out.println("---------------------------------");

        long count = Stream.of("AB", "AF", "FFF", "AAA", "DG", "AD", "EF")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3; })//;//Need Terminal operation to execute
                .count();

        System.out.println(count);

    }
}