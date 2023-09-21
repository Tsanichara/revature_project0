package Model;

public class Order {
    int order_id;
    int customer_id;
    int product_id;

    public Order(int order_id, int customer_id, int product_id) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.product_id = product_id;
    }

    public Order(int customer_id, int product_id) {
        this.customer_id = customer_id;
        this.product_id = product_id;
    }

    public Order() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
