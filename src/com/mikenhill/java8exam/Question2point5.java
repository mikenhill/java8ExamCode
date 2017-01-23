package com.mikenhill.java8exam;

import java.awt.List;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Question2point5 {

	public static void main(String[] args) {
		
//		int total = 0; 
//		StringBuilder letters = new StringBuilder(" abcdefg"); 
//		total += letters.substring( 1, 2).length(); 
//		total += letters.substring( 6, 6).length(); 
//		String xx = letters.substring( 6, 5); 
//		System.out.println( total);
		
		StringBuilder numbers = new StringBuilder("0123456789"); 
		numbers.delete( 2, 8); 
		numbers.append("-"). insert( 2, "+"); 
		System.out.println( numbers);

		String myX = new String("0123456789");
		myX = myX.substring(1,3);
		System.out.println( myX);
		
		StringBuilder b = new StringBuilder("rumble"); 
		b.append( 4). deleteCharAt( 3). delete( 3, b.length() - 1);
		System.out.println( b);
		b.reverse();
		java.util.Date[] dates[] = new java.util.Date[ 2][];

		java.util.List c = new ArrayList();
		int length = c.size();
		int numFish = 4; 
		String fishType = "tuna"; 
		String anotherFish = numFish + "" + 1; 
		System.out.println( anotherFish + " " + fishType); 
		System.out.println( numFish + " " + 1);

		ArrayList < Integer > values = new ArrayList <>();

		LocalDate date = LocalDate.of( 2018, Month.APRIL, 40); 
		System.out.println( date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());

		
		
		
	}

}
