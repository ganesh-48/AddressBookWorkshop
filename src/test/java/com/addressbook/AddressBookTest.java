package com.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddressBookTest {


    @Test
    public void givenContactInAddressBookReturnTrue() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899L, "abc@gmail.com");
        HashMap<String, List<Contacts>> contactsList = addressBook.addContacts("Details", contacts);
        Assertions.assertEquals(1, contactsList.get("Details").size());
    }

    @Test
    public void givenEditNameInAddressBookWhenNameReturnTrue() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899L, "abc@gmail.com");
        HashMap<String, List<Contacts>> contactsList = addressBook.addContacts("Details", contacts);
        boolean result = addressBook.editContacts(contactsList, "Details", "Ram", "address", "Line-3");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEditNameInAddressBookWhenNameNotMatchReturnFalse() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899L, "abc@gmail.com");
        HashMap<String, List<Contacts>> contactsList = addressBook.addContacts("Details", contacts);
        boolean result = addressBook.editContacts(contactsList, "Details", "Ram", "address", "Line-3");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenNameWhenDeleteShouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899L, "abc@gmail.com");
        HashMap<String, List<Contacts>> contactsList = addressBook.addContacts("Details", contacts);
        boolean result = addressBook.deleteContacts(contactsList, "Details", "Ram");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenNameWhenNotDeleteShouldRetrunFalse() {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899L, "abc@gmail.com");
        HashMap<String, List<Contacts>> contactsList = addressBook.addContacts("Details", contacts);
        boolean result = addressBook.deleteContacts(contactsList, "Family", "Ram");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenListOfMultipleContactsWhenAddedShouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        List<Contacts> contactDataList = new ArrayList<>();
        contactDataList.add(new Contacts("Sai", "Sale", "saiPalace", "Solapur", "Maharashtra", 413102, 9654923567L, "sai@gmail.com"));
        contactDataList.add(new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899L, "abc@gmail.com"));
        HashMap<String, List<Contacts>> contactsList = addressBook.addContactsList("Details", contactDataList);
        Assertions.assertEquals(3, contactsList.get("Details").size());
    }

    @Test
    public void givenDuplicateEntryWhenDuplicateContactShouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        List<Contacts> contactDataList = new ArrayList<>();
        contactDataList.add(new Contacts("Sai", "Sale", "saiPalace", "Solapur", "Maharashtra", 413102, 9654923567L, "sai@gmail.com"));
        contactDataList.add(new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899L, "abc@gmail.com"));
        HashMap<String, List<Contacts>> contactsList = addressBook.addContactsList("Details", contactDataList);
        Assertions.assertNotEquals(3, contactsList.get("Details").size());
    }

    @Test
    public void givenDuplicateEntryWhenDuplicateContactShouldReturnFalse() {
        AddressBook addressBook = new AddressBook();
        List<Contacts> contactDataList = new ArrayList<>();
        contactDataList.add(new Contacts("Sai", "Sale", "saiPalace", "Solapur", "Maharashtra", 413102, 9654923567L, "sai@gmail.com"));
        contactDataList.add(new Contacts("Sai", "Sale", "saiPalace", "Solapur", "Maharashtra", 413102, 9654923567L, "sai@gmail.com"));
        contactDataList.add(new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899L, "abc@gmail.com"));
        HashMap<String, List<Contacts>> contactsList = addressBook.addContactsList("Details", contactDataList);
        Assertions.assertNotEquals(3, contactsList.get("Details").size());
    }
}
