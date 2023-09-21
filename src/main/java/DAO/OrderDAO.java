package DAO;

import Model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    private Connection conn;

    public OrderDAO(Connection conn){
        this.conn = conn;
    }

    public Order insertOrder(Order order){

        try{
            String sql = "INSERT INTO Orders (order_id, customer_id, product_id) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, order.getOrder_id());
            preparedStatement.setInt(2, order.getCustomer_id());
            preparedStatement.setInt(3, order.getProduct_id());

            preparedStatement.executeUpdate();

            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_order_id = (int) pkeyResultSet.getLong(1);

                return new Order(generated_order_id, order.getCustomer_id(), order.getProduct_id());

            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Order> getAllOrders(){
        List<Order> orders = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Orders";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Order order = new Order(rs.getInt("order_id"), rs.getInt("customer_id"), rs.getInt("product_id"));

                orders.add(order);
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return orders;
    }

    public Order getOrderById(int id){

        try{
            String sql = "SELECT * FROM Orders WHERE order_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Order order = new Order(rs.getInt("order_id"), rs.getInt("customer_id"), rs.getInt("product_id"));

                return order;
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void deleteOrderById(int id){

        try{
            String sql = "DELETE FROM Orders WHERE order_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
