package com.example.lr3.models;

import jakarta.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int goodsId;
    @Column
    private String customerName;
    @Column
    private String customerEmail;
    @Column
    private String address;
    @Column
    private boolean paid;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getGoodsId() { return goodsId; }

    public void setGoodsId(int goodsId) { this.goodsId = goodsId; }

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerEmail() { return customerEmail; }

    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public boolean isPaid() { return paid; }

    public void setPaid(boolean paid) { this.paid = paid; }
}
