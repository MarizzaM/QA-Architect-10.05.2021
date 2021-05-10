package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {

    private String m_conn;

    public CustomerDAO(String m_conn) {
        this.m_conn = m_conn;
    }


    public ArrayList<Customer> getAllCustomers(){

        ArrayList<Customer> customers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {

                String sql = "SELECT * FROM Customer";

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Customer e = new Customer(
                            rs.getInt("Id"),
                            rs.getString("Name"),
                            rs.getFloat("Stars"),
                            rs.getInt("birth_year"));
                    customers.add(e);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  customers;
    }

    public Customer getCustomerById(int id){
        // try to connect to db
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                // prepare query string
                String sql = String.format("Select * from Customer where id = %d", id );

                // prepare statement
                Statement stmt = conn.createStatement();

                // fire query
                ResultSet rs = stmt.executeQuery(sql);

                // read results
                while (rs.next()) {
                    Customer e = new Customer(
                            rs.getInt("Id"),
                            rs.getString("Name"),
                            rs.getFloat("Stars"),
                            rs.getInt("birth_year"));
                    return e;
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

}
