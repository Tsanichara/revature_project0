package Service;

import DAO.OrderDAO;
import Model.Order;

import java.util.List;

public class OrderService {

    OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }

    public Order addOrder(Order order){
        return orderDAO.insertOrder(order);
    }

    public List<Order> getAllOrders(){
        return orderDAO.getAllOrders();
    }

    public Order getOrderById(int id){
        return orderDAO.getOrderById(id);
    }

    public void deleteOrder(int id){
        orderDAO.deleteOrderById(id);
    }
}
