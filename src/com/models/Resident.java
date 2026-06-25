package com.barangay.models;

public class Resident {
    private String name;
    private int age;

    public Resident(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    @Override
    public String toString() { return "Resident{name='" + name + "', age=" + age + "}"; }
    @Override
    public boolean equals(Object o) { return (o instanceof Resident r) && r.name.equals(this.name); }
    @Override
    public int hashCode() { return name.hashCode(); }
}