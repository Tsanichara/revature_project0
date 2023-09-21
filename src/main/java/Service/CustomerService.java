package Service;

import DAO.CustomerDAO;
import Model.Customer;

public class CustomerService {
    CustomerDAO customerDAO;

    public CustomerService (CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }


    public void addCustomer(Customer con) {

        customerDAO.insertCustomer(con);
    }


    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    public int getCustomerId(String name) {
        int num =  customerDAO.getCustomerId(name);
        return num;
    }
}
