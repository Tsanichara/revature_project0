package DAO;

import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {
    private Connection conn;

    public ProductDAO(Connection conn) {
        this.conn = conn;

    }

    public void insertProduct(Product p){

        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Product (productId, productName, productPrice) values (?, ?, ?");
            ps.setInt(1, p.getProductId());
            ps.setString(2, p.getProductName());
            ps.setInt(3, p.getProductPrice());
            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void deleteProduct(String productName){
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM product where productName = ?");
            ps.setString(1, productName);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String getProductById(int id){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT productName from Product where productId =  ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("productName");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
