package com.company.state;

class Main {
    public static void main(String[] args) {
        Person person = new Person("John Smith");
        System.out.println(person);

        person.setPersonState(new LowerCaseState());
        System.out.println(person);
        person.setPersonState(new MrMrsState());
        System.out.println(person);

    }
}

public class Person {
    //toLowerCase
    //toUpperCase

    private State personState;


    private String name;

    public Person(String name) {
        this.name = name;
        this.personState = new UpperCaseState();
    }

    public String getName() {
        return this.personState.getName(this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonState(State personState) {
        this.personState = personState;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + this.personState.getName(name) + '\'' +
                '}';
    }
}

interface State {
    String getName(String initialName);
}

class MrMrsState implements State {
    @Override
    public String getName(String initialName) {
        return "Mr. (Mrs.) " + initialName;
    }
}

class UpperCaseState implements State {
    @Override
    public String getName(String initialName) {
        if (initialName != null) {
            return initialName.toUpperCase();
        }
        return null;
    }
}

class LowerCaseState implements State {

    @Override
    public String getName(String initialName) {
        if (initialName != null) {
            return initialName.toLowerCase();
        }
        return null;
    }
}
