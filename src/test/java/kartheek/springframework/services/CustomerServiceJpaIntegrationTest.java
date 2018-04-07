package kartheek.springframework.services;

import kartheek.springframework.config.JpaIntegrationConfig;
import kartheek.springframework.models.Customer;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class CustomerServiceJpaIntegrationTest {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void testList() throws Exception {
        List<Customer> customers = (List<Customer>) customerService.listAll();
        assertThat(customers.size(), is(3));
    }

    @Ignore
    @Test
    public void testGetById() throws Exception {

        Integer customerId = 1;
        Customer customer = customerService.getById(customerId);
        assertThat(customer.getId(), is(1));
    }

    @Ignore
    @Test
    public void testSave() throws Exception {

        Customer customer = new Customer();
        customer.setZipCode("44304");
        customer.setPhoneNumber("4057144199");
        customer.setEmail("vadlamani@gmail.com");
        customer.setCity("cuyahoga falls");
        customer.setFirstName("kartheek");

        Customer savedCustomer = customerService.saveOrUpdate(customer);

        assertThat(savedCustomer.getZipCode(), is("44304"));
        assertThat(savedCustomer.getPhoneNumber(), is("4057144199"));
    }

    @Ignore
    @Test
    public void testUpdate() throws Exception {

        Integer customerId = 1;
        Customer customer = customerService.getById(customerId);
        customer.setCity("cuyahoga falls");
        customer.setFirstName("kartheek");


        Customer updatedCustomer= customerService.saveOrUpdate(customer);
        assertThat(updatedCustomer.getCity(), is("cuyahoga falls"));
        assertThat(updatedCustomer.getFirstName(), is("kartheek"));
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {

        List<Customer> customerList = (List<Customer>) customerService.listAll();
        System.out.println(customerList.size());
        assertThat(customerList.size(), is(3));
        Integer customerId = 2;
        customerService.delete(customerId);

        List<Customer> updatedCustomerList = (List<Customer>) customerService.listAll();

        assertThat(updatedCustomerList.size(), is(2));
    }

}
