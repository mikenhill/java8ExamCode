package com.mikenhill.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class ReducingDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Shyam", 22,"A");
        Student s2 = new Student("Ram",23,"A");
        Student s3 = new Student("Mohan",22,"B");
        Student s4 = new Student(null,21,"B");
        List<Student> list = Arrays.asList(s1,s2,s3,s4);
        Comparator<Student> ageComparator = Comparator.comparing(Student::getAge); 
        
        Stream<Student> strStudent = list.stream();
        Collectors.reducing(BinaryOperator.maxBy(ageComparator))
        
        Map<String, Optional<Student>> eldestByClass = list.stream().collect(Collectors.groupingBy(Student::getClassName, 
                Collectors.reducing(BinaryOperator.maxBy(ageComparator))));
        eldestByClass.forEach((k,v)->System.out.println("Class:"+k+" Age:"+
                ((Optional<Student>)v).get().getAge()+" Name:"+((Optional<Student>)v).get().getName()));
    }
} 