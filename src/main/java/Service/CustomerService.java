package Service;

import DAO.CustomerDAO;
import Model.Customer;

import java.util.List;

public class CustomerService {
    CustomerDAO customerDAO;

    public CustomerService (CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }


    public void addCustomer(Customer con) {
        customerDAO.insertCustomer(con);
    }

    public List<Customer> getAllCustomer() {
        return   customerDAO.getAllCustomer();
    }


    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    public Customer getCustomerId(int id) {
        Customer num =  customerDAO.getCustomerId(id);
        return num;
    }
}