package com.etateck._2_Streams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/****************************************************
 *** Created by Fady Fouad on 6/18/2019 at 21:16.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("\n---------------------Streams-----------------------------\n");
//        String s = "J9l27307";
//        System.out.println("WiFi PassWord --->  "+s.toUpperCase());
        List<String>nums = Arrays.asList(
                "A3","A1","A2","a4",
                "B1","B2","B3",
                "C1","C2","C3",
                "D1","D2","D3",
                "E1","E2","E3");

//        List<String>nList = new ArrayList<>();
//        nums.forEach(number -> {
//            if (number.startsWith("A")){
//                System.out.println("Start With \"A\" --> "+number);
//                nList.add(number);
//            }
//        });
//
//        nList.sort(String::compareTo);//Lambda Method Reference
//        System.out.println(nList.toString());
//        List<String>strings = new ArrayList<>();
//        strings.add("S1");
//        strings.add("S2");
//        strings.add("S3");
//
//        strings.sort(String::compareTo);
//        System.out.println(strings);

        nums.stream()
                .map(String::toUpperCase)
//                .map(string->string.toUpperCase())
                .filter(s -> s.startsWith("A"))
                .sorted()
//                .forEach(System.out::println);
                .forEach(System.out::println);

    }
}