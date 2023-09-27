package Service;

import DAO.ProductDAO;
import Model.Product;

import java.util.List;

public class ProductService {
    ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(Product p) {
        productDAO.insertProduct(p);
    }

    public void deleteProduct(int productId){
        productDAO.deleteProduct(productId);

    }

    public Product getProductNameById(int id){
        return productDAO.getProductById(id);
    }

    public List<Product> getAllProducts(){
       return productDAO.getAllProducts();
    }

    public Product updateProduct(int id, Product product){
        if (productDAO.getProductById(id) == null){
            return null;
        } else{
            productDAO.updateProduct(id, product);
            return productDAO.getProductById(id);
        }
    }
}

