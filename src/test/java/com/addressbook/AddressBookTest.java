package com.addressbook;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class AddressBookTest {
    AddressBookList addressBookList = new AddressBookList();
    List<Contacts> addressBookContactList;

    @Test
    public void givenThreeContactsInDBWhenRetrievedShouldMatchEmployeeCount() {
        AddressBookList addressBookList = new AddressBookList();
        addressBookContactList = addressBookList.readAddressBookData(AddressBookList.IOService.DB_IO);
        Assertions.assertEquals(3, addressBookContactList.size());
    }

    @Test
    public void givenContactDataInDBWhenUpdatedShouldSynchronizeWithDBTrue() {
        addressBookList = new AddressBookList();
        addressBookContactList = addressBookList.readAddressBookData(AddressBookList.IOService.DB_IO);
        addressBookList.updateContact("Line-3", "Ram");
        boolean result = addressBookList.checkAddressBookInSyncWithDB("Ram");
        Assertions.assertTrue(result);
    }
    @Test
    public void givenContactDataInDBWhenNotUpdatedShouldSynchronizeWithDBTrue() {
        addressBookList = new AddressBookList();
        addressBookContactList = addressBookList.readAddressBookData(AddressBookList.IOService.DB_IO);
        addressBookList.updateContact("Solapur", "sai");
        boolean result = addressBookList.checkAddressBookInSyncWithDB("Ram");
        Assertions.assertTrue(result);
    }
}
