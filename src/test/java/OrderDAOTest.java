import DAO.CustomerDAO;
import DAO.OrderDAO;


import DAO.ProductDAO;

import Model.Order;

import Util.ConnectionSingleton;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;
public class OrderDAOTest {
    Connection conn;
    OrderDAO orderDAO;
    CustomerDAO customerDAO;
    ProductDAO productDAO;


    @Before
    public void setUp(){

        conn = ConnectionSingleton.getConnection();
        ConnectionSingleton.resetTestDatabase();
        customerDAO = new CustomerDAO(conn);
        productDAO = new ProductDAO(conn);
        orderDAO = new OrderDAO(conn);

    }

    @Test
    public void getAllOrdersTest(){
        List<Order> allOrders = orderDAO.getAllOrders();


        Order o1 = new Order(1234, 1, 3);
        Order o2 = new Order(1111, 2, 1);
        Order o3 = new Order(2222, 2, 2);

        Assert.assertTrue(allOrders.contains(o1));
        Assert.assertTrue(allOrders.contains(o2));
        Assert.assertTrue(allOrders.contains(o3));
    }

    @Test
    public void getOrderByIdTest(){
        Order order = orderDAO.getOrderById(1234);
        if (order == null){
            Assert.fail();
        } else {
            Order o1 = new Order(1234, 1, 3);
            Assert.assertTrue(order.equals(o1));

        }

    }

}
