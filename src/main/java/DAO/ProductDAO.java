package DAO;

import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection conn;

    public ProductDAO(Connection conn) {
        this.conn = conn;

    }

    public void insertProduct(Product p){

        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Product (productId, productName, productPrice) values (?, ?, ?)");
            ps.setInt(1, p.getProductId());
            ps.setString(2, p.getProductName());
            ps.setInt(3, p.getProductPrice());
            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void deleteProduct(int productId){
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Product where productId = ?");
            ps.setInt(1, productId);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Product getProductById(int id){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * from Product where productId =  ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int prodId = rs.getInt("productId");
                String prodName = rs.getString("productName");
                int prodPrice = rs.getInt("productPrice");
                Product dbProduct = new Product(prodId, prodName, prodPrice);
                return dbProduct;
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();

        try{
            String sql = "SELECT * FROM Product";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("productPrice"));

                products.add(product);
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return products;
    }

    public void updateProduct(int id, Product product){

        try{
            String sql = "Update Product SET productName = ?, productPrice = ? WHERE productId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getProductPrice());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
