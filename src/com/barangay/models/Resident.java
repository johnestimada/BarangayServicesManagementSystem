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

   

    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Resident{name='" + name + "', age=" + age + ", '" + address + "'}";
    }

    @Override
    public int compareTo(Resident other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Resident)) return false;
        Resident other = (Resident) obj;
        return this.name.equalsIgnoreCase(other.name) && this.age == other.age;
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode() + age;
    }
}