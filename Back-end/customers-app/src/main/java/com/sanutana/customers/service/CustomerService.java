package com.sanutana.customers.service;

import com.sanutana.customers.maskers.Masker;
import com.sanutana.customers.message.responses.CustomersListResponse;
import com.sanutana.customers.domain.ContactInfo;
import com.sanutana.customers.domain.Customer;
import com.sanutana.customers.message.responses.CustomerByIdResponse;
import com.sanutana.customers.message.responses.saveCustomerResponse;
import com.sanutana.customers.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public List<Customer> getAllCustomers() {
        List<Customer> result = customerRepository.findAll();
        String message = String.format("found %d customers", result.size());
        return result;
    }

    public CustomerByIdResponse getCustomerById(Long id) {
        Customer result = customerRepository.findById(id).get();
        logger.info("here are all the customers: \n" + result);
        return CustomerByIdResponse.builder().returnCode(0).customer(result).build();
    }

    public saveCustomerResponse saveCustomer(Customer customer) {
        Customer cust = customerRepository.save(customer);
        String message = String.format("saved successfully", cust.getId());
        return saveCustomerResponse.builder().returnCode(0).message(message).customer(cust).build();
    }


    public void addContact(Long id, ContactInfo contactInfo) {
        customerRepository.addContact(id, contactInfo.getEmail(), contactInfo.getPhone());
        System.out.println("reached");
    }


    public CustomerByIdResponse getMaskedContactById(Long id) {
        Customer result = customerRepository.findById(id).get();
        String maskedEmail = Masker.contactMasker(result.getContact().getEmail());
        String maskedPhone = Masker.contactMasker(result.getContact().getPhone());
        ContactInfo maskedContact = new ContactInfo(maskedEmail, maskedPhone);
        result.setContact(maskedContact);

        logger.info("here is the masked contact: \n" + result);
        return CustomerByIdResponse.builder().returnCode(0).customer(result).build();
    }
}
