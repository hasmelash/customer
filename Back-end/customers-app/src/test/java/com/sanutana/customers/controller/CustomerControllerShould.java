package com.sanutana.customers.controller;

import com.sanutana.customers.domain.ContactInfo;
import com.sanutana.customers.domain.Customer;
import com.sanutana.customers.message.responses.CustomersListResponse;
import com.sanutana.customers.repository.CustomerRepository;
import com.sanutana.customers.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class CustomerControllerShould {


    @InjectMocks
    CustomerController customerController;

    @Mock
    CustomerService customerService;



    @Test
    public void testSaveCustomer() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

//        when(customerService.saveCustomer(any(Customer.class)).getReturnCode()).thenReturn(0);

        ContactInfo contact = new ContactInfo("heni@outlook.com", "147-852-9632");
        Customer customer = new Customer(null, "heno", "asme", contact);

        ResponseEntity<?> responseEntity = customerController.saveCustomer(customer);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void testGetAllCustomers() {
        ContactInfo contact = new ContactInfo("heni@outlook.com", "147-852-9632");
        Customer customer1 = new Customer((long)1, "heno", "asme", contact);
        Customer customer2 = new Customer((long)2, "heni", "ber", contact);
        Customer customer3 = new Customer((long)3, "hen", "berhan", contact);

        List<Customer> customers = Arrays.asList(customer1,customer2,customer3);

        when(customerService.getAllCustomers()).thenReturn(customers);
        ResponseEntity<?> responseEntity = customerController.getAllCustomers();

        assertThat(responseEntity.getBody()).isEqualTo(customers);
    }

}
