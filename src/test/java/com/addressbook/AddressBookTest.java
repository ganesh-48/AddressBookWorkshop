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

    @Test
    public void givenEditNameInAddressBookWhenNameReturnTrue() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899, "abc@gmail.com");
        boolean result = addressBook.addContacts(contacts);
        Contacts editContact = addressBook.editContacts(addressBook.contactList, "Ram", "address","editContacts");
        Assertions.assertEquals("Line-3", editContact.address);
    }

    @Test
    public void givenEditNameInAddressBookWhenNameNotMatchReturnFalse() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899, "abc@gmail.com");
        boolean result = addressBook.addContacts(contacts);
        Contacts editContacts = addressBook.editContacts(addressBook.contactList, "Ram", "address","contacts");
        Assertions.assertEquals("Line-3", editContacts.address);
    }
}
