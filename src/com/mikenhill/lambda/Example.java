package com.mikenhill.lambda;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

public class Example {
	 
    public int add(int a, int b) {
        return a + b;
    }
 
    public static int mul(int a, int b) {
        return a * b;
    }
 
    public String lower(String a) {
        return a.toLowerCase();
    }
 
    public void printDate(Date date) {
        System.out.println(date);
    }
 
    public void oper(IntBinaryOperator operator, int a, int b) {
        System.out.println(operator.applyAsInt(a, b));
    }
 
    public void operS(Function<String, String> stringOperator, String a) {
        System.out.println(stringOperator.apply(a));
    }
 
    public GregorianCalendar operC(Supplier<GregorianCalendar> supplier) {
        return supplier.get();
    }
 
} 
