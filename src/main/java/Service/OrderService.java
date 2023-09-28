package Service;

import DAO.OrderDAO;
import Model.Order;

import java.util.List;

public class OrderService {

    OrderDAO orderDAO;

    /**
     *
     * An OrderService object is initialized using an OrderDAO as a parameter.
     */
    public OrderService(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }

    /**
     * the addOrder method allows you to add an order to the Orders table by calling the insertOrder method of the OrderDAO.
     */
    public Order addOrder(Order order){
        return orderDAO.insertOrder(order);
    }

    /**
     *
     * the getAllOrders method calls the getAllOrders method of the OrderDAO to retrieve all orders.
     */

    public List<Order> getAllOrders(){
        return orderDAO.getAllOrders();
    }

    /**
     * the getOrderById method returns an order from the Orders table using the id as a parameter.
     */

    public Order getOrderById(int id){
        return orderDAO.getOrderById(id);
    }

    /**
     * the deleteOrder method deletes an order from the Orders table using an id.
     */

    public void deleteOrder(int id){
        orderDAO.deleteOrderById(id);
    }
}
