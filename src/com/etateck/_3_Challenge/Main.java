package com.etateck._3_Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/****************************************************
 *** Created by Fady Fouad on 6/19/2019 at 18:32.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String s = "Lets split this Line";
            String[] sParts = s.split(" ");
//            for (String sPart : sParts) {
//                System.out.println(sPart);
//            }
            List<String> strings = new ArrayList<>(Arrays.asList(sParts));
            strings.forEach(System.out::println);
        };

        new Thread(runnable).start();
    }
}