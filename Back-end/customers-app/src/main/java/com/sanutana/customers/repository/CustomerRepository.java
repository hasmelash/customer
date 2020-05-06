package com.sanutana.customers.repository;

import com.sanutana.customers.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

        @Query(value = "update Customer ex set ex.contact.email = :email, ex.contact.phone = :phone where ex.id = :customerId")
        @Modifying
        @Transactional
        void addContact(@Param("customerId") Long customerId,
                        @Param("email") String email,
                        @Param("phone") String phone);
}
