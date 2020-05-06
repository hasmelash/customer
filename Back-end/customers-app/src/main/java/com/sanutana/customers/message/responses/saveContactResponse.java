package com.sanutana.customers.message.responses;

import com.sanutana.customers.domain.ContactInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class saveContactResponse {
    Integer returnCode;
    String message;
    ContactInfo contactInfo;
}
