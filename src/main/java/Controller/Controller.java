package Controller;

import DAO.OrderDAO;
import Model.Customer;
import Model.Order;
import Model.Product;
import Service.CustomerService;
import Service.OrderService;
import Service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;


public class Controller {

    CustomerService customerService;
    ProductService productService;
    OrderService orderService;

    public Controller(CustomerService customerService, ProductService productService, OrderService orderService){
        this.customerService = customerService;
        this.productService = productService;
        this.orderService = orderService;
    }

    public Javalin getAPI() {
        Javalin app = Javalin.create();


        app.post("/product", this::postProductHandler);
        app.get("/product/{id}", this::getProductByIdHandler);
        app.get("/product", this::getAllProductsHandler);
        app.delete("/product/{id}", this::deleteProductByIdHandler);
        app.patch("/product/{id}", this::updateProductHandler);
        app.get("/Orders", this::getAllOrdersHandler);
        app.get("/Orders/{order_id}", this::getOrderByIdHandler);
        app.delete("/Orders/{order_id}", this::deleteOrderHandler);
        app.post("/Orders", this::postOrderHandler);
        app.post("/customer", this::addCustomerHandler);
        app.delete("/customer/{id}", this::deleteCustomerHandler);
        app.get("/customer/{id}", this::getCustomerIdHandler);
        app.get("/customer", this::getAllCustmer);

        return app;
    }

    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void postProductHandler(Context context) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Product product = om.readValue(context.body(), Product.class);
        productService.addProduct(product);


    }

    private void getProductByIdHandler(Context ctx){
        int id = Integer.parseInt(ctx.pathParam("id"));
        Product p = productService.getProductNameById(id);
        ctx.json(p);
    }

    private void deleteProductByIdHandler(Context ctx){
        int id = Integer.parseInt(ctx.pathParam("id"));
        Product deletedProduct = productService.getProductNameById(id);
        productService.deleteProduct(id);

        if(deletedProduct == null){
            ctx.status(200);
        } else{
            ctx.json(deletedProduct);
        }
    }

    private void updateProductHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.readValue(ctx.body(), Product.class);
        int id = Integer.parseInt(ctx.pathParam("id"));

        Product updatedProduct = productService.updateProduct(id, product);

        if((updatedProduct == null)){
            ctx.status(400);
        } else {
            ctx.json(mapper.writeValueAsString(updatedProduct));
        }
    }

    private void getAllProductsHandler(Context ctx){
        ctx.json(productService.getAllProducts());
    }

    private void getAllOrdersHandler(Context ctx){
        ctx.json(orderService.getAllOrders());
    }

    private void postOrderHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Order order = om.readValue(ctx.body(), Order.class);
        Order addedOrder = orderService.addOrder(order);

        if(addedOrder == null){
            ctx.status(400);
        } else {
            ctx.json(om.writeValueAsString(addedOrder));
        }
    }

    private void getOrderByIdHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();

        int order_id = Integer.parseInt(ctx.pathParam("order_id"));
        Order retrievedOrder = orderService.getOrderById(order_id);

        if (retrievedOrder == null){
            ctx.status(200);
        } else {
            ctx.json(om.writeValueAsString(retrievedOrder));
        }
    }

    private void deleteOrderHandler(Context ctx){
        int order_id = Integer.parseInt(ctx.pathParam("order_id"));
        Order deletedOrder = orderService.getOrderById(order_id);
        orderService.deleteOrder((order_id));

        if(deletedOrder == null){
            ctx.status(200);
        } else {
            ctx.json(deletedOrder);
        }
    }
    public void getAllCustmer(Context context) {
        context.json(customerService.getAllCustomer());
    }

    public void deleteCustomerHandler(Context context) {
        int id = Integer.parseInt(context.pathParam("id"));
        customerService.deleteCustomer(id);
    }

    public void getCustomerIdHandler(Context context) {
        int id = Integer.parseInt(context.pathParam("id"));
        Customer c = customerService.getCustomerId(id);
        context.json(c);
    }
    private void addCustomerHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(context.body(),Customer.class);
        customerService.addCustomer(customer);
        context.status(201);
    }


}
