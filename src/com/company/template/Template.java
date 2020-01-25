package com.company.template;

class Main {
    public static void main(String[] args) {
        Template template = new JavaTemplate();
        template.execute();
    }
}

public abstract class Template {
    public final void execute() {
        openIDE();
        writeCode();
        runAndTest();
        sendToCustomer();
    }

    public abstract void openIDE();
    public abstract void writeCode();
    public abstract void runAndTest();
    public abstract void sendToCustomer();
}

class JavaTemplate extends Template {

//      Will not compile
//    @Override
//    public void execute() {
//        super.execute();
//    }

    @Override
    public void openIDE() {
        System.out.println("Open Intellij");
    }

    @Override
    public void writeCode() {
        System.out.println("Java");
    }

    @Override
    public void runAndTest() {
        System.out.println("Running with Maven and Test with JUnit");
    }

    @Override
    public void sendToCustomer() {
        System.out.println("GitHub");
    }
}

class CSharpTemplate extends Template {
    @Override
    public void openIDE() {
        System.out.println("Open Visual Studio");
    }

    @Override
    public void writeCode() {
        System.out.println("C#");
    }

    @Override
    public void runAndTest() {
        System.out.println("Run via CMD and Test using NUnit");
    }

    @Override
    public void sendToCustomer() {
        System.out.println("Sub-Version");
    }
}