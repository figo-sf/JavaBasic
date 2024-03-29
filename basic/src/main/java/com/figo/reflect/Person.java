package com.figo.reflect;

public class Person {

    private int age;

    private String name;

    private double price;

    public Person() {
        super();
    }

    public Person(int age, String name, double price) {
        super();
        this.age = age;
        this.name = name;
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

