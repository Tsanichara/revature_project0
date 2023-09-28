package Service;

import DAO.ProductDAO;
import Model.Product;

import java.util.List;

public class ProductService {
    ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    /**
     * The addProduct method adds a new product to the Products table.
     */

    public void addProduct(Product p) {
        productDAO.insertProduct(p);
    }

    /**
     * the deleteProduct method deletes a product from the Products table based on the id that was input.
     */
    public void deleteProduct(int productId){
        productDAO.deleteProduct(productId);

    }
    /**
     * The getProductNameById method retrieves a product from the Products table based on the id that was input.
     */
    public Product getProductNameById(int id){
        return productDAO.getProductById(id);
    }
    /**
     * The getAllProducts method retrieves all products from the Products table.
     */
    public List<Product> getAllProducts(){
       return productDAO.getAllProducts();
    }
    /**
     * The updateProduct method allows you to update an existing product in the Products table.
     */
    public Product updateProduct(int id, Product product){
        if (productDAO.getProductById(id) == null){
            return null;
        } else{
            productDAO.updateProduct(id, product);
            return productDAO.getProductById(id);
        }
    }
}

