package DAO;

import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CustomerDAO {
    Connection conn;


    public CustomerDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * The getCustomerId method retrieves customer record by querying the darabase with the use of its ID.
     * @param id
     * @return
     */

    public Customer getCustomerId(int id) {

        try {
            PreparedStatement ps = conn.prepareStatement("select * from Customer where id = ? ");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                int ido = rs.getInt("id");
                String name = rs.getString("f_name");
                Customer customer = new Customer(ido, name);
                return customer;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * The getallCustomer method retrieves all customer record from the database
     * @return
     */

    public List<Customer> getAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Customer");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("f_name");
                Customer newCus = new Customer(id,name);
                customerList.add(newCus);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    /**
     * The insertCustomer method inserts a new customer record into the database.
     * @param cus
     */
    public void insertCustomer(Customer cus) {
        try{
            PreparedStatement ps = conn.prepareStatement("insert into Customer (id,f_name) values (?, ?)");
            ps.setInt(1, cus.getId());
            ps.setString(2, cus.getF_name());
            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * The deleteCustomer method deletes a customer record from the database using it's ID.
     * @param id
     */
    public void deleteCustomer(int id) {
        try{
            PreparedStatement ps = conn.prepareStatement("delete from Customer where Customer.id = ?" );
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * The updatecustomerById method updates a customer record in the database using it's ID.
     * @param id
     * @param customer
     */
    public void updateCustomerById(int id,Customer customer) {
        try {
            PreparedStatement ps = conn.prepareStatement("update Customer set f_name = ? where id = ?");
            ps.setString(1,customer.getF_name());
            ps.setInt(2,id);
            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }





}