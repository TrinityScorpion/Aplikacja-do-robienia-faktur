package com.example;

public class DocumentItem {
    private int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public DocumentItem(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
