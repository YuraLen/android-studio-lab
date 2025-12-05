package com.example.myapplication;

public class Product {
    private final String name;
    private int count;
    private final String unit;

    Product(String name, String unit){
        this.name = name;
        this.count = 0;
        this.unit = unit;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getName(){
        return this.name;
    }
}