package com.etateck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/****************************************************
 *** Created by Fady Fouad on 6/16/2019 at 21:17.***
 ***************************************************/
public class Employee {
    private String name;
    private int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

}
//    class TestClass {
//        String doSomting() {
//            System.out.println("Test Class Name : " + getClass().getSimpleName());
//            return Main.doStringStuff((String s1, String s2) -> {
//                System.out.println("Anon Class Name : " + getClass().getSimpleName());
//                return s1 + " " + s2;
//            });
//        }
//
//        void printValue(){
//            int i;
//            i = 0;
//            Runnable runnable = () -> {
//                try{
//                    Thread.sleep(300);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Value = "+i);
//            };
//            new Thread(runnable).start();
//        }
//    }
//}