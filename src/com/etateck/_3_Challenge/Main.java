package com.etateck._3_Challenge;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

/****************************************************
 *** Created by Fady Fouad on 6/19/2019 at 18:32.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------Challenge #1--------------------------------");
//        Runnable runnable = () -> {
//            String s = "Lets split this Line";
//            String[] sParts = s.split(" ");
//            Arrays.stream(sParts).forEach(System.out::println);
//        };
//        new Thread(runnable).start();
        System.out.println("---------------------Challenge #2--------------------------------");
        Function<String ,String>stringStringFunction = s->{
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Fady");
            for (int i = 0; i < s.length(); i++) {
                if (i%2==1){
                    stringBuilder.append(s.charAt(i));
                    System.out.println(stringBuilder);
                }
                System.out.println(stringBuilder);
            }
            return stringBuilder.toString();
        };
        stringStringFunction.apply("Fady");
        System.out.println("---------------------Challenge #3--------------------------------");
        Function<String ,String>numStringFn = num->{
            StringBuilder numBuilder = new StringBuilder();
            for (int i = 0; i < num.length(); i++) {
                if ( i%2 == 1 ){
                    numBuilder.append(num.charAt(i));
                }
            }
            System.out.println(numBuilder);
            return numBuilder.toString();
        };
        numStringFn.apply("1234567890");
//        System.out.println(numStringFn.apply("1234567890"));
        System.out.println("---------------------Challenge #4--------------------------------");
        everySecond(numStringFn,"1234567890");
//        System.out.println(results);
        System.out.println("---------------------Challenge #4--------------------------------");
        Supplier<String >iLoveJava = ()->"I Love Java";
        String supRes = iLoveJava.get();
        System.out.println(supRes);
    }


    private static String everySecond(Function<String,String >function,String source){
        return function.apply(source);
    }
}