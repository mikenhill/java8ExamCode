package com.mikenhill.lambda.personList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class PersonLambda {

	public static void main (String [] args) {
		PersonLambda pl = new PersonLambda();
		pl.sort();
	}
	
	private void sort () {
		//Create 3 people
		Person p1 = new Person();
		p1.setCountry(Country.UK.getName());
		p1.setName("p1");
		
		Person p2 = new Person();
		p2.setCountry(Country.UK.getName());
		p2.setName("p2");
		
		Person p3 = new Person();
		p3.setCountry(Country.SP.getName());
		p3.setName("p3");
		
		List<Person> pList = new ArrayList<Person>();
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		
		pList.forEach((s) -> System.out.println(s));
		pList.forEach(System.out::println);
		
		Predicate<? super Person> spanish = p -> {
											return new Boolean(Country.SP.getName().equals("Spain"));
										  };
		
        pList.stream().filter(spanish).forEach((s) -> System.out.println(s));			
        
        List<String> lString = new ArrayList<String>();
        lString.add("xxx");
        printCollection(lString);
        
        Map<String, Person> mMap = new HashMap<String, Person>();
        mMap.put("mike", p2);
        addRegistry(mMap);
	}
	
	public static void addRegistry(Map<String, ? extends Person> registry) {
		for (Object e : registry.keySet()) {
			System.out.println(e);
		}
		
	}
	
	void printCollection(Collection<?> c) {
	    for (Object e : c) {
	        System.out.println(e);
	    }
	}
	
}

