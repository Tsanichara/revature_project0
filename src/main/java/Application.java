import Controller.Controller;
import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import Model.Product;
import Service.CustomerService;
import Service.OrderService;
import Service.ProductService;
import Util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {



//        this line is just for testing that your tables get set up correctly
//        if not, you'll get a stack trace
        Connection conn = ConnectionSingleton.getConnection();
        ProductDAO productDAO = new ProductDAO(conn);
        ProductService productService = new ProductService(productDAO);
        CustomerDAO customerDAO = new CustomerDAO(conn);
        CustomerService customerService = new CustomerService(customerDAO);
        OrderDAO orderDAO = new OrderDAO(conn);
        OrderService orderService = new OrderService(orderDAO);

//        this line is for starting the javalin server
        Controller controller = new Controller(customerService, productService, orderService);
        controller.getAPI().start();







        }
    }
