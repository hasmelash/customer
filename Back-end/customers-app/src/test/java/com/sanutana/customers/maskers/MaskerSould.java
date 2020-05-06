package com.sanutana.customers.maskers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaskerShould {



    @Test
    void maskContact() {
        List<String> contacts = Arrays.asList("henockberhane@gmail.com", "(123) 456-8789", "+1 (123) 456-8259");
        List<String> expectedValues = Arrays.asList("h***********e@gmail.com", "(123) ***-8789", "+1 (123) ***-8259");
        for(String contact: contacts) {
            String maskedValue = Masker.contactMasker(contact);
            assertEquals(expectedValues.get(contacts.indexOf(contact)), maskedValue);
        }

    }

}
