package com.automation.tests.day13;

// Java program implementing Singleton class
// with getInstance() method
class Singleton {

    // static variable single_instance of type Singleton
    private static Singleton single_instance = null;

    // variable of type String
    public String s;

    // private constructor restricted to this class itself
    private Singleton() {
        s = "Hello I am a string part of Singleton class";
    }

    // static method to create instance of Singleton class
    // use /*Singleton()*/ is want to implement Singleton class with method name as that of class name
    public static Singleton getInstance() /*Singleton()*/ {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
}
class Main
{
    public static void main(String[] args) {

        // instantiating Singleton class with variable x
        Singleton x = Singleton.getInstance() /*Singleton()*/ ;
        // instantiating Singleton class with variable y
        Singleton y = Singleton.getInstance() /*Singleton()*/ ;

        // instantiating Singleton class with variable z
        Singleton z = Singleton.getInstance() /*Singleton()*/ ;
        // changing variable of instance x
        x.s = (x.s).toUpperCase();
        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");
        // changing variable of instance zz.s = (z.s).toLowerCase();
        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");

    }
}
