package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {
    static ArrayList<Customer> customers = new ArrayList<>();
    CustomerDAO customerDAO = new CustomerDAO("jdbc:sqlite:C:/SQLite/Customers.db");

    @GetMapping("/customer")
    public ArrayList<Customer> getCustomers(){
        return customerDAO.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer doGetCustomerById(@PathVariable("id") int id)
    {
        return customerDAO.getCustomerById(id);
    }

    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer c)
    {
        customerDAO.insertCustomer(c);
    }

    @PutMapping("/customer/{id}")
    public void doUpdateCustomerByID(@PathVariable("id") int id,
                                     @RequestBody Customer sent)
    {
        customerDAO.updateCustomer(sent, id);
    }

    @DeleteMapping ("/customer/{id}")
    public void deleteCustomerById(@PathVariable("id") int id)
    {
        customerDAO.deleteCustomer(id);
    }
}
