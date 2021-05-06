package com.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AddressBookTest {

    public void initialize() {
        AddressBook addressBook;
            }
    @Test
    public void givenContactInAddressBookReturnTrue() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899, "abc@gmail.com");
        List<Contacts> result = addressBook.addContacts(contacts);
        Assertions.assertEquals(result, "Ram");
    }

    @Test
    public void givenEditNameInAddressBookWhenNameReturnTrue() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899, "abc@gmail.com");
        List<Contacts> result = addressBook.addContacts(contacts);
        Contacts editContact = addressBook.editContacts(addressBook.contactList, "Ram", "address","editContacts");
        Assertions.assertEquals("Line-3", editContact.address);
    }

    @Test
    public void givenEditNameInAddressBookWhenNameNotMatchReturnFalse() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899, "abc@gmail.com");
        List<Contacts> result = addressBook.addContacts(contacts);
        Contacts editContacts = addressBook.editContacts(addressBook.contactList, "Ram", "address","contacts");
        Assertions.assertEquals("Line-3", editContacts.address);
    }

    @Test
    public void givenNameWhenDeleteShouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899, "abc@gmail.com");
        List<Contacts> contactsList = addressBook.addContacts(contacts);
        List<Contacts> deleteContactList = addressBook.deleteContacts(contactsList, "Ram");
        Assertions.assertEquals(1, deleteContactList.size());
    }

    @Test
    public void givenNameWhenNotDeleteShouldRetrunFalse() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899, "abc@gmail.com");
        List<Contacts> contactsList = addressBook.addContacts(contacts);
        List<Contacts> deleteContactList = addressBook.deleteContacts(contactsList, "Sai");
        Assertions.assertEquals(1, deleteContactList.size());
    }

    @Test
    public void givenListOfMultipleContactsWhenAddedShouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        List<Contacts> contactDataList = new ArrayList<>();
        contactDataList.add(new Contacts("Sai", "Salunkhe", "saiNiwas", "Solapur", "Maharashtra", 413102, 9654923567l, "sai@gmail.com"));
        contactDataList.add(new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899, "abc@gmail.com"));
        List<Contacts> contactList = addressBook.addMultipleContactsList(contactDataList);
        Assertions.assertEquals(2, contactList.size());
    }
}
