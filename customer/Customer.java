package com.example.demo;

public class Customer {
    private int id;
    private String name;
    private float stars;
    private int birth_year;

    public Customer() {
    }

    public Customer(int id, String name, float stars, int birth_year) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.birth_year = birth_year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getStars() {
        return stars;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", birth_year=" + birth_year +
                '}';
    }
}

