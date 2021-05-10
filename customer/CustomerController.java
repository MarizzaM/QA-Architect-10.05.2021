package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
//
//    @PostMapping("/customer")
//    public String addCustomer(@RequestBody Customer c)
//    {
//        m_customers.add(c);
//        return "Customer add";
//    }
//
//    @PutMapping("/customer/{id}")
//    public String doUpdateCustomerByID(@PathVariable("id") int id,
//                                     @RequestBody Customer sent)
//    {
//        for (Customer c : m_customers) {
//            if (c.getId() == id){
//                c.setId(sent.getId());
//                c.setName(sent.getName());
//                c.setAddress(sent.getAddress());
//                return  "Customer updated";
//            }
//        }
//        return "Customer not found";
//    }
//
//    @DeleteMapping ("/customer/{id}")
//    public String deleteCustomerById(@PathVariable("id") int id)
//    {
//        Iterator<Customer> it = m_customers.iterator();
//        while(it.hasNext()) {
//            Customer i = it.next();
//            if(i.getId() == id) {
//                it.remove();
//                return "Customer deleted";
//            }
//        }
//        return "Customer not found";
//    }
}
