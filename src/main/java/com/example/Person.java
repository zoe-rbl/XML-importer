package com.example;

public class Person{

    //Instantiation of variables
    private String name;
    private String surname;
    private int matrikelNummer;
    private String function;

    //Constructor for Person
    public Person(int matrikelNummer, String name, String surname, String function){
        this.matrikelNummer = matrikelNummer;
        this.name = name;
        this.surname = surname;
        this.function = function;
    }

    //getters and setters

    public int getMatrikelNummer(){
        return matrikelNummer;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getFunction(){
        return function;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setSurname(String newSurname){
        this.surname = newSurname;
    }

    public void setFunction(String newFunction){
        this.function = newFunction;
    }

    public String toString(){
        return "Person number : " + matrikelNummer + " -> " + name + ", " + surname + " - " + function + "\n";
    }


}