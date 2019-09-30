/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Main{
    
    public static void main(String[] args){
    List<Person> persons= list();
    
    //iperative aproach
    for(Person person:persons){
            if(person.getGender().equals(Gender.FEMALE)){
            System.out.println(person);
            }
    }
      //declerative aproach
      
    List<Person> females= persons.stream()
             .filter(
              person-> person.getGender().equals(Gender.FEMALE))
             .collect(Collectors.toList());
    
     females.forEach(System.out::println);

     //Sort with age
     
    List<Person> sorted= ( persons.stream()
             .sorted(Comparator.comparing(Person::getAge))
            .collect(Collectors.toList()));
    
   boolean match= persons.stream().allMatch(person-> person.getAge()>20);
    System.out.println(match);
    
    boolean anymatch=persons.stream().anyMatch(person-> person.getAge()>=65);
    System.out.println(anymatch);
    
    boolean nonematch=persons.stream()
            .noneMatch(person-> person.getName().equals("Giorgos"));
    
    System.out.println(nonematch);
    
    persons.stream()
            .max(Comparator.comparing(Person::getAge))
            .ifPresent(System.out::println);
    
    persons.stream()
            .min(Comparator.comparing(Person::getAge))
            .ifPresent(System.out::println);
    //Group male,female
    
   Map<Gender, List<Person>> groupByGender= persons.stream()
            .collect(Collectors.groupingBy(Person::getGender));
   
   groupByGender.forEach((gender,people)->{
    System.out.println(gender);
    people.forEach(System.out::println);
    });
   
   System.out.println(persons.stream()
                           .filter(person-> person.getGender().equals(Gender.FEMALE))
                           .max(Comparator.comparing(Person::getAge))
                           .map(Person::getName));
}
    
  
 
    
    
    
    public static List<Person> list(){
        return Arrays.asList(
                new Person("Giorgos",28,Gender.MALE),
                new Person("Xristina",27,Gender.FEMALE),
                new Person("Varvara",56,Gender.FEMALE),
                new Person("Xristos",36,Gender.MALE),
                new Person("Athanasos",64,Gender.MALE),
                new Person ("Kuriakos",26,Gender.MALE)
        );
    
    }

}
