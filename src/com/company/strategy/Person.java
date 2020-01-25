package com.company.strategy;

class Main {
    public static void main(String[] args) {
        Person person = new Person("John", new ToUpperCaseStrategy());
        System.out.println(person);

        //person save to JSON or XML
        //Json Strategy, XML Strategy


    }
}

public class Person {

    private String name;
    private Strategy strategy;

    public Person(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public String getName() {
        return strategy.getName(this.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + this.strategy.getName(name) + '\'' +
                '}';
    }
}


interface Strategy {
    String getName(String initialName);
}

class ToUpperCaseStrategy implements Strategy {
    @Override
    public String getName(String initialName) {

        //Guard Clause
        if (initialName == null) {
            return null;
        }


        return initialName.toUpperCase();
    }
}
