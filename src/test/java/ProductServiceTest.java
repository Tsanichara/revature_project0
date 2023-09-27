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
    @Test
    public void getAllProductsServiceTest(){
        List<Product> allProducts = new ArrayList<>();

        allProducts.add(new Product(5, "Notebook", 15));
        allProducts.add(new Product(6, "Pants", 22));
        allProducts.add(new Product(7, "Pillow", 25));
        Mockito.when(mockProductDAO.getAllProducts()).thenReturn((allProducts));
        Assert.assertEquals(allProducts, productService.getAllProducts());
    }

}
