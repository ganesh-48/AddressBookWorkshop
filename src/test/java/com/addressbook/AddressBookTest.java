package com.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressBookTest {

    public void initialize() {
        AddressBook addressBook;
            }
    @Test
    public void givenContactInAddressBookReturnTrue() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899, "abc@gmail.com");
        boolean result = addressBook.addContacts(contacts);
        Assertions.assertTrue(result);
    }
}
