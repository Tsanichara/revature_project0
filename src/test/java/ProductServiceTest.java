import DAO.ProductDAO;
import Model.Product;
import Service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    public ProductDAO mockProductDAO;
    public ProductService productService;

    @Before
    public void setUp(){
        mockProductDAO = Mockito.mock(ProductDAO.class);
        productService = new ProductService(mockProductDAO);

    }
    /**
     * This is a unit test to test if the getAllProducts method of the Service layer is working correctly.
     */
    @Test
    public void getAllProductsServiceTest(){
        List<Product> allProducts = new ArrayList<>();

        allProducts.add(new Product(5, "Notebook", 15));
        allProducts.add(new Product(6, "Pants", 22));
        allProducts.add(new Product(7, "Pillow", 25));
        Mockito.when(mockProductDAO.getAllProducts()).thenReturn((allProducts));
        Assert.assertEquals(allProducts, productService.getAllProducts());
    }

    /**
     * This is a unit test to test if the getProductById method of the Service layer is working correctly.
     */
    @Test
    public void getProductByIdServiceTest(){
        Product newProduct = new Product(10, "Shoes", 22);

        Mockito.when(mockProductDAO.getProductById(newProduct.getProductId())).thenReturn(newProduct);
        Product product = mockProductDAO.getProductById(10);
        Assert.assertEquals(newProduct, product);
    }


    /**
     * This is a unit test to test if the addProduct method of the Service layer is working correctly.
     */
    @Test
    public void addProductServiceTest(){
        Product newProduct = new Product(10,"Shoes", 22);
        Product persistedProduct = new Product(10, "Shoes", 22);
        Mockito.when(mockProductDAO.getProductById(newProduct.getProductId())).thenReturn(persistedProduct);

        productService.addProduct(newProduct);
        Assert.assertEquals(newProduct, productService.getProductNameById(10));
    }



}
