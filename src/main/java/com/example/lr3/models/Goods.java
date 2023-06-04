package com.example.lr3.models;

import jakarta.persistence.*;

@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private String category;

    public int getId() { return id; }

    public void setId(int id) { this.id = id;  }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }
}
