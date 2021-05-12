package com.example.demo;

public class Order {

    private int id;
    private String item_name ;
    private int quantity;
    private float price;
    private String customer_name;

    public Order() {
        super();
    }

    public Order(int id, String item_name, int quantity, float price, String customer_name) {
        this.id = id;
        this.item_name = item_name;
        this.quantity = quantity;
        this.price = price;
        this.customer_name = customer_name;
    }

    public int getId() {
        return id;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", item_name='" + item_name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", customer_name='" + customer_name + '\'' +
                '}';
    }
}
