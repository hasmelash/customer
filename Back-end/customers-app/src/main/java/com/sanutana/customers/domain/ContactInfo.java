package com.sanutana.customers.domain;


import com.sanutana.customers.annotation.Phone;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Embeddable
public class ContactInfo {

    @NotEmpty
    @Size(max = 80)
    @Email
    private String email;

    @Size(max = 80)
    @Phone
    private String phone;


}
