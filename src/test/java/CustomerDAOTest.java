import DAO.CustomerDAO;
import Model.Customer;
import Util.ConnectionSingleton;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class CustomerDAOTest {
    Connection conn;
    CustomerDAO customerDAO;

    @Before
    public void setUp() {
        conn = ConnectionSingleton.getConnection();
        customerDAO = new CustomerDAO(conn);
    }

    /**
     * As a user, you should be able to retrieve customer data by it's ID.
     */
    @Test
    public void customerDAO_CheckForCustomerById() {
        Customer customer = new Customer(1, "dave");
        customerDAO.getCustomerId(1);
        Customer expectedCustomer = new Customer(1, "dave");
        Customer actualCustomer = new Customer(1, "dave");
        Assert.assertEquals(expectedCustomer, actualCustomer);
    }

    /**
     * Alternatively, we check if a wrong customer ID can be used to retrieve customer data.
     */
    @Test
    public void customerDAO_CheckForCustomerByIdDidNotExist() {
        Customer customer = new Customer(1, "dave");
        customerDAO.getCustomerId(-2);
        Customer expectedCustomer = new Customer(1, "dave");
        Customer actualCustomer = new Customer(1, "dave");
        Assert.assertEquals(expectedCustomer, actualCustomer);
    }


    /**
     * As a user, the customer data should be retrievable when the getAllCustomer() is invoked.
     */

    @Test
    public void customerDAO_RetrieveAllCustomerData() {
        List<Customer> allCustomer = customerDAO.getAllCustomer();
        Customer dave = new Customer(1, "Calum Smith");
        Customer jane = new Customer(2, "John Doe");
        Customer smith = new Customer(3, "Dave Reuben");
        Customer mike = new Customer(4, "Mic Jagger");
        Assert.assertTrue("Customer list should contain Calim Smith", allCustomer.contains(dave));
        Assert.assertTrue("Customer list should contain John Doe", allCustomer.contains(jane));
        Assert.assertTrue("Customer list should contain Dave Reuben", allCustomer.contains(smith));
        Assert.assertTrue("Customer list should contain Mic Jagger", allCustomer.contains(mike));
    }


    /**
     * When adding a customer to the customerDAO, the data added shou;d be retrievable.
     */
    @Test
    public void customerDAO_CheckIfCustomerIsAdded() {
        Customer customer = new Customer(5, "Calum Smith");
        customerDAO.insertCustomer(customer);
        Customer expectedCustomer = new Customer(5, "Calum Smith");

        List<Customer> actualCustomer = customerDAO.getAllCustomer();
        Assert.assertTrue(actualCustomer.contains(expectedCustomer));

    }

    /**
     * When a customer is added, it can also be deleted from the customer record.
     */
    @Test
    public void customerDAO_CheckingIfACustomerIsDeleted() {
        Customer customer = new Customer(5, "dave");
        customerDAO.insertCustomer(customer);
        customerDAO.deleteCustomer(5);
        List<Customer> allCustomeer = customerDAO.getAllCustomer();
        Assert.assertFalse(allCustomeer.contains(customer));
    }

    /**
     * When a customer's record is updated, it should be retrievable.
     */
    @Test
    public void customerDAO_CheckingIfCustomerDataIsUpdatedById() {
        Customer customer = new Customer(2, "John Doe");
        customerDAO.updateCustomerById(1, customer);
        Customer expectedCustomer = new Customer(1, "John Doe");
        Customer actualCustomer = customerDAO.getCustomerId(1);
        Assert.assertEquals(expectedCustomer, actualCustomer);
    }


}
