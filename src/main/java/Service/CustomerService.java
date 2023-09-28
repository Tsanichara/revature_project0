package Service;

import DAO.CustomerDAO;
import Model.Customer;

import java.util.List;

public class CustomerService {
    CustomerDAO customerDAO;

    public CustomerService (CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    /**
     * The addcustomer method take a customer as a parameter and adds it to the insertCustomer
     * method in the customerDAO
     * @param con
     */
    public void addCustomer(Customer con) {
        customerDAO.insertCustomer(con);
    }

    /**
     * The getAllCustomer method retrieves the customer records via the customerDAO with
     * the getAllCustomer method and returns it as a list.
     * @return
     */
    public List<Customer> getAllCustomer() {
        return   customerDAO.getAllCustomer();
    }


    /**
     * The deleteCustomer deletes acustomer record by using it's ID via the deleteCustomer method
     * in the customerDAO.
     * @param id
     */
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    /**
     * The getCustomerId method retrieves a customer record by it's ID vis the getCustomerId mrthod
     * in the cutomerDAO
     * @param id
     * @return
     */
    public Customer getCustomerId(int id) {
        Customer num =  customerDAO.getCustomerId(id);
        return num;
    }

    /**
     * The updateCustomerById updates a customer record with a new customer and it's ID
     * @param id
     * @param customer
     */
    public void updateCustomerById(int id, Customer customer) {
        customerDAO.updateCustomerById(id, customer);
    }
}
