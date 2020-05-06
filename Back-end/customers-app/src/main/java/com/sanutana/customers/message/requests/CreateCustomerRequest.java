package com.sanutana.customers.message.requests;

import com.sanutana.customers.domain.ContactInfo;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CreateCustomerRequest {

    private String firstName;

    private String lastName;

    private ContactInfo contact;

}
