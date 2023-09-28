package Model;

import java.util.Objects;

public class Order {
    int order_id;
    int customer_id;
    int product_id;

    /**
     * Several different constructors with different parameters are listed here in order to initialize a new Order object.
     */
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

    /**
     * These are getter and setter methods to interact with each data variable in an Order object.
     *
     */

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return order_id == order.order_id && customer_id == order.customer_id && product_id == order.product_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, customer_id, product_id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", customer_id=" + customer_id +
                ", product_id=" + product_id +
                '}';
    }
}
