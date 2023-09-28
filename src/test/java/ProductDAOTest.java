import DAO.ProductDAO;
import Model.Product;
import Util.ConnectionSingleton;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class ProductDAOTest {
    Connection conn;
    ProductDAO productDAO;

    /**
     * Before each unit test a connection to the database is established and the test database is reset.
     */
    @Before
    public void setUp(){
        conn = ConnectionSingleton.getConnection();
        ConnectionSingleton.resetTestDatabase();
        productDAO = new ProductDAO(conn);
    }
    /**
     * This tests if the getAllProducts method is working properly.
     */
    @Test
    public void getAllProductsTest(){
        List<Product> allProducts = productDAO.getAllProducts();



        Product p1 = new Product(1, "Apple", 5);
        Product p2 = new Product(2,"Chair", 40);
        Product p3 = new Product(3, "TV", 200);

        Assert.assertTrue(allProducts.contains(p1));
        Assert.assertTrue(allProducts.contains(p2));
        Assert.assertTrue(allProducts.contains(p3));

    }
    /**
     * This tests if the getProductById method is working properly.
     */
    @Test
    public void getProductByIdTest(){
        Product product = productDAO.getProductById(1);
        if(product == null){
            Assert.fail();
        } else {
            Product p1 = new Product(1, "Apple", 5);
            Assert.assertTrue(product.equals(p1));
        }
    }
    /**
     * This tests if the deleteProduct method is working properly.
     */
    @Test
    public void deleteProductTest(){
        Product p4 = new Product(4, "Shirt", 20);
        productDAO.insertProduct(p4);
        productDAO.deleteProduct(4);
        Assert.assertNull(productDAO.getProductById(4));

    }
    /**
     * This tests if the insertProduct method is working properly.
     */
    @Test
    public void insertProductTest(){
        Product p4 = new Product(4, "Shirt", 20);
        productDAO.insertProduct(p4);
        Product p4expected  = new Product(4, "Shirt", 20);
        Product p4actual = productDAO.getProductById(4);
        Assert.assertEquals(p4expected, p4actual);
    }
    /**
     * This tests if the updateProduct method is working properly.
     */
    @Test
    public void updateProductTest(){
        Product updatedProduct = new Product(1, "Tomato", 2);
        productDAO.updateProduct(1, updatedProduct);

        Product updatedProductExpected = updatedProduct;
        Product updatedProductActual = productDAO.getProductById(1);
        Assert.assertEquals(updatedProductExpected, updatedProductActual);

    }
}
