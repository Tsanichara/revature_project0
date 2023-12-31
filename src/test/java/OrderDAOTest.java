import DAO.CustomerDAO;
import DAO.OrderDAO;


import DAO.ProductDAO;

import Model.Order;

import Util.ConnectionSingleton;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Or;

import java.sql.Connection;
import java.util.List;
public class OrderDAOTest {
    Connection conn;
    OrderDAO orderDAO;


    /**
     * Before each unit test a connection to the database is established and the test database is reset.
     */
    @Before
    public void setUp(){

        conn = ConnectionSingleton.getConnection();
        ConnectionSingleton.resetTestDatabase();

        orderDAO = new OrderDAO(conn);

    }


    /**
     * This is a unit test to test if the getAllOrders method of the DAO layer is working correctly.
     */
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
    /**
     * This is a unit test to test if the getOrderById method of the DAO layer is working correctly.
     */
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
    /**
     * This is a unit test to test if the insertOrder method of the DAO layer is working correctly.
     */
    @Test
    public void insertOrderTest(){
        Order o4 = new Order(6,2, 1);
        orderDAO.insertOrder(o4);
        Order o4expected = new Order(6,2,1);
        Order o4actual = orderDAO.getOrderById(6);
        Assert.assertEquals(o4expected, o4actual);
    }

    /**
     * This is a unit test to test if the deleteOrder method of the DAO layer is working correctly.
     */
    @Test
    public void deleteOrderTest(){
        Order o4 = new Order(6,2, 1);
        orderDAO.insertOrder(o4);
        orderDAO.deleteOrderById(6);
        Assert.assertNull(orderDAO.getOrderById(6));
    }

}
