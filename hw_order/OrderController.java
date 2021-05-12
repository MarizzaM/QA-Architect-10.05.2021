package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class OrderController {
    OrderDAO orderDAO = new OrderDAO("jdbc:sqlite:C:/SQLite/Orders.db");

    @GetMapping("/order")
    public ArrayList<Order> getOrders(){
        return orderDAO.getAllOrders();
    }

    @GetMapping("/order/{id}")
    public Order doGetOrderById(@PathVariable("id") int id){
        return orderDAO.getOrderById(id);
    }

    @PostMapping("/order")
    public void addOrder(@RequestBody Order order){
        orderDAO.insertOrder(order);
    }

    @PutMapping("/order/{id}")
    public void doUpdateOrderByID(@PathVariable("id") int id, @RequestBody Order sent){
        orderDAO.updateOrder(sent, id);
    }

    @DeleteMapping ("/order/{id}")
    public void deleteOrderById(@PathVariable("id") int id){
        orderDAO.deleteOrder(id);
    }

    @GetMapping ("/price/{id}")
    public float getPriceOrderById(@PathVariable("id") int id){
        return orderDAO.getPriceOrderById(id);
    }

    @GetMapping ("/price")
    public float getTotal(){
        return orderDAO.getTotalPrice();
    }
}
