import DAO.CustomerDAO;
import Model.Customer;
import Service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceTest {

    CustomerService customerService;
    CustomerDAO mockCustomerDAO;

    /**
     * The setup method runs before the test commences setting and connecting CusomerDAO and CustomerService
     * to Mockito
     */
    @Before
    public void setUp() {
        mockCustomerDAO = Mockito.mock(CustomerDAO.class);
        customerService = new CustomerService(mockCustomerDAO);
    }

    /**
     * The customerService_getAllCustomerTest checks if all customer records are retrievable.
     */

    @Test
    public void customerService_getAllCustomerTest() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(5,"Joy Walker"));
        customerList.add(new Customer(6,"Chio Yang"));
        customerList.add(new Customer(7,"Tunde Ola"));
        Mockito.when(mockCustomerDAO.getAllCustomer()).thenReturn(customerList);
        Assert.assertEquals(customerList,customerService.getAllCustomer());

    }

    /**
     * The customerService_ChecKIfCustomerIAddedTest method checks if the customer record are retrievable
     * bt their ID
     */

    @Test
    public void customerService_ChecKIfCustomerIdAddedTest() {
        Customer newCustomer = new Customer(7,"Sean Brehm");
        Customer persistedCustomer = new Customer(7, "Sean Brehm");
        Mockito.when(mockCustomerDAO.getCustomerId(newCustomer.getId())).thenReturn(persistedCustomer);
        customerService.addCustomer(newCustomer);
        Assert.assertEquals(newCustomer,customerService.getCustomerId(7));
        //Mockito.verify(mockCustomerDAO).insertCustomer(Mockito.any());
    }

    /**
     * The customerService_CheckIfCustomerIsUpdatedTest method checks if a customer record can be
     * updated using its ID.
     */

    @Test
    public void customerService_CheckIfCustomerIsUpdatedTest() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(5,"Jay walker"));
        customerList.add(new Customer(6,"Chio Yang"));
        customerList.add(new Customer(7,"Tunde Ola"));
        Customer newCustomer = new Customer(7,"Tunde Ola");
        // Customer expectedCustomer = new Customer(7,"Tunde Ola"):
        Mockito.when(mockCustomerDAO.getAllCustomer()).thenReturn(customerList);
        customerService.updateCustomerById(7,newCustomer);

        Mockito.verify(mockCustomerDAO).updateCustomerById(7,newCustomer);
        Assert.assertTrue(customerList.contains(newCustomer));
    }





}