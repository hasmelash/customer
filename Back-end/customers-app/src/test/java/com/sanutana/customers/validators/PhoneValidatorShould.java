package com.sanutana.customers.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneValidatorShould {

    @Test
    void validatePhoneNumber() {
        PhoneValidator phoneValidator = new PhoneValidator();
        String phone = "703-634-8259";
        assertTrue(phoneValidator.isValid(phone, null));
    }

}
