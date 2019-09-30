/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream;

/**
 *
 * @author George
 */
public class Person {
    private final String name;
    private final int age;
    private final Gender gender;
    
    public Person(String newName, int newAge, Gender newGender){
        this.name=newName;
        this.age=newAge;
        this.gender=newGender;
    
    }
    
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public Gender getGender(){
        return this.gender;
    }
    
    @Override
    public String toString(){
        return("name:"+name
                +" Age:"+age
                +" Gender:"+gender.toString().toLowerCase());
                        
        
    }
  }
