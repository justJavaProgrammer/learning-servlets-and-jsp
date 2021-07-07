package edu.odeyalko.servlets.crudservlet;

public class Car {
    private String name;
    private int age;
    private String owner;

    public Car(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}

