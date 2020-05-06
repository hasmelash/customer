package com.sanutana.customers.repository;

import com.sanutana.customers.domain.ContactInfo;
import com.sanutana.customers.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;



    @Test
    void whenAddingContact_setContactToCustomer() {
        //given
        ContactInfo contact1 =new ContactInfo("henockberhane@gmail.com", "703-634-5289");
        Customer customer = new Customer(null,  "Henock", "Berhane", null);
        customer.setContact(contact1);
        entityManager.persistAndFlush(customer);
        //when
        Customer foundCust = entityManager.find(Customer.class, entityManager.getId(customer));
        customerRepository.addContact(foundCust.getId(), "nahom@gmail.com", "703-989-0000");
        Customer foundCust2 = entityManager.find(Customer.class, entityManager.getId(customer));

        //then
        assertThat(foundCust2.getContact().getPhone()).isEqualTo(customer.getContact().getPhone());
    }


}
