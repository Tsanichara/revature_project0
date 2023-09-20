import Controller.Controller;
import DAO.ProductDAO;
import Model.Product;
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
//        this line is for starting the javalin server
        Controller controller = new Controller();
        controller.getAPI().start();

        ProductDAO productDAO = new ProductDAO(conn);
        ProductService productService = new ProductService(productDAO);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1: Add new product 2: Get product by Id 3: Delete product by name");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.println("Enter product ID");
                int productId = Integer.parseInt(sc.nextLine());
                System.out.println("enter product name");
                String productName = sc.nextLine();
                System.out.println("enter price");
                int price = Integer.parseInt(sc.nextLine());

                Product prod = new Product(productId, productName, price);

                productService.addProduct(prod);

            } else if (choice == 2) {

                System.out.println("enter product ID");
                int productID = Integer.parseInt(sc.nextLine());
                String productName = productService.getProductNameById(productID);
                System.out.println(productName);


            } else if(choice == 3) {

                System.out.println("enter product name");
                String name = sc.nextLine();
                productService.deleteProduct(name);
            }

        }
    }
}