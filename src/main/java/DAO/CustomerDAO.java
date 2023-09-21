package DAO;

import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CustomerDAO {
    Connection conn;



    public CustomerDAO(Connection conn) {
        this.conn = conn;
    }



    public int getCustomerId(String f_name) {

        try {
            PreparedStatement ps = conn.prepareStatement("select id from Customer where Customer.f_name = ? ");
            ps.setString(1, f_name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                int name = rs.getInt("id");
                return name;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String insertCustomer(Customer cus) {
        try{
            PreparedStatement ps = conn.prepareStatement("insert into Customer (id,f_name) values (?, ?)");
            ps.setInt(1, cus.getId());
            ps.setString(2, cus.getF_name());
            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteCustomer(int id) {
        try{
            PreparedStatement ps = conn.prepareStatement("delete from Customer where Customer.id = ?" );
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }





}
