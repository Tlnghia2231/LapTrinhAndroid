package com.example.myapplication;

public class Number {
    String id;
    int number;

    public Number(String id, int number) {
        this.id = id;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
