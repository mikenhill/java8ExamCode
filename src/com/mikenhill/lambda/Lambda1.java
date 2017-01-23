package com.mikenhill.lambda;

import java.util.function.Function;

public class Lambda1 {

	public static void main (String [] args) {
		Function<String, String> function = x -> x.toUpperCase();
		Function<String, String> function2 = x -> x.toLowerCase();
		convertString(function);// prints STRANGE
		convertString(function2);// prints strange
		
		Example ex = new Example();
		ex.oper((a, b) -> Example.mul(a, b), 1, 1);
		ex.operS(s-> ex.lower(s), "STRING");
	}
	
	public static void convertString(Function<String, String> function){
	    System.out.println(function.apply("StRaNgE"));
	}
	
	
}
