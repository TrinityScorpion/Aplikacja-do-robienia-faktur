package com.example.exercise;

public class Warehouse {
    private String location;
    private int capacity;

    public Warehouse(String location, int capacity) {
        this.location = location;
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
