package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAO {

    private String m_conn;

    public OrderDAO(String m_conn) {
        this.m_conn = m_conn;
    }

    public ArrayList<Order> getAllOrders(){

        ArrayList<Order> orders = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {

                String sql = "SELECT * FROM MyOrder";

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Order e = new Order(
                            rs.getInt("id"),
                            rs.getString("item_name"),
                            rs.getInt("quantity"),
                            rs.getFloat("price"),
                            rs.getString("customer_name"));
                    orders.add(e);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  orders;
    }

    public Order getOrderById (int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = "SELECT * FROM MyOrder WHERE id = " + id;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    Order order = new Order(
                            rs.getInt("id"),
                            rs.getString("item_name"),
                            rs.getInt("quantity"),
                            rs.getFloat("price"),
                            rs.getString("customer_name"));
                    return order;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void insertOrder(Order order){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = String.format("INSERT INTO MyOrder (item_name, quantity, price, customer_name)" +
                        " VALUES ('%s', %d, %f, '%s')", order.getItem_name(), order.getQuantity(),
                        order.getPrice(), order.getCustomer_name());
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateOrder(Order order, int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = String.format("UPDATE MyOrder SET " +
                                "item_name = '%s', " +
                                "quantity = %d, " +
                                "price = %f, " +
                                "customer_name = '%s'" +
                                " WHERE id = %d", order.getItem_name(), order.getQuantity(),
                        order.getPrice(), order.getCustomer_name(), order.getId());
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteOrder(int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = "DELETE FROM MyOrder WHERE id = " + id;
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public float getPriceOrderById(int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = "SELECT * FROM MyOrder WHERE id = " + id;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    Order order = new Order(
                            rs.getInt("id"),
                            rs.getString("item_name"),
                            rs.getInt("quantity"),
                            rs.getFloat("price"),
                            rs.getString("customer_name"));
                    return order.getPrice()*order.getQuantity();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public float getTotalPrice(){
        float sum = 0;
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = "SELECT * FROM MyOrder ";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    Order order = new Order(
                            rs.getInt("id"),
                            rs.getString("item_name"),
                            rs.getInt("quantity"),
                            rs.getFloat("price"),
                            rs.getString("customer_name"));
                    sum += order.getPrice()*order.getQuantity();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sum;
    }
}
