package com.barangay.models;

public class Resident implements Comparable<Resident> {
    private String name;
    private int age;
    private String address;

    public Resident(String name, int age) {
        this.name = name;
        this.age = age;
        this.address = "";
    }

    public Resident(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return "Resident{name='" + name + "', age=" + age + ", address='" + address + "'}";
    }

    @Override
    public int compareTo(Resident other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}