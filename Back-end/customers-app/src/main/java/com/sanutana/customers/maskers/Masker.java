package com.sanutana.customers.maskers;

public interface Masker {

    static String contactMasker(String contact) {
        int index = contact.indexOf("@");
        String result = null;
        if (index >= 0) { //email
            result = contact.replaceAll("(?<=.{1}).(?=[^@]*?.@)", "*");
        } else if (contact.matches(".*[-.]\\d{4}$")) { //case 2  - 123-456-7890      case 3  - (112) 456-7289      case 4  - +1 (123) 456-8259
            result = handleFormattedPhones(contact);
        } else if (contact.matches(".*\\d{5}$")) { // case 1  - 1234567890
            result = handleUnformattedPhones(contact);
        }
        return result;
    }

    static String handleFormattedPhones(String contact) {
        String lastFiveDigits = contact.substring(contact.length() - 5);
        String uptoTheStartOfMiddleNums = contact.substring(0, contact.length() - 8);
        return String.format(uptoTheStartOfMiddleNums + "***" + lastFiveDigits);
    }

    static String handleUnformattedPhones(String contact) {
        String lastFourDigits = contact.substring(contact.length() - 4);
        String uptoTheStartOfMiddleNums = contact.substring(0, contact.length() - 7);
        return String.format(uptoTheStartOfMiddleNums + "***" + lastFourDigits);
    }
}
