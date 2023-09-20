package Service;

import DAO.ProductDAO;
import Model.Product;

public class ProductService {
    ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(Product p) {
        productDAO.insertProduct(p);
    }

    public void deleteProduct(String productName){
        productDAO.deleteProduct(productName);

    }

    public String getProductNameById(int id){
        return productDAO.getProductById(id);
    }
}
