import DAO.OrderDAO;
import Model.Order;

import Service.OrderService;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceTest {
    public OrderDAO mockOrderDAO;
    public OrderService orderService;

    @Before
    public void setUp() {
        mockOrderDAO = Mockito.mock(OrderDAO.class);
        orderService = new OrderService(mockOrderDAO);
    }

    @Test
    public void getAllOrdersTest(){
        List<Order> allOrders = new ArrayList<>();

        allOrders.add(new Order(5, 1, 2));
        allOrders.add(new Order(6, 1, 3));
        allOrders.add(new Order(7, 2, 1));

        Mockito.when(mockOrderDAO.getAllOrders()).thenReturn(allOrders);
        Assert.assertEquals(allOrders, orderService.getAllOrders());
    }
}
