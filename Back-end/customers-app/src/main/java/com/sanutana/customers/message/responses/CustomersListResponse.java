package com.sanutana.customers.message.responses;

import com.sanutana.customers.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CustomersListResponse {
    Integer returnCode;
    String message;
    List<Customer> customers;
}
