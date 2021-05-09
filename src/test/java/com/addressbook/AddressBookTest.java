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

    @Test
    public void givenContactDataInDBWhenCountByCityShouldMatchReturnTrue() {
        addressBookList = new AddressBookList();
        List<Contacts>  addressBookDataList = addressBookList.countByCity("Solapur");
        Assertions.assertEquals(3, addressBookDataList.size());
    }

    @Test
    public void givenContactDataInDBWhenCountByCityShouldMatchReturnFalse() {
        addressBookList = new AddressBookList();
        List<Contacts>  addressBookDataList = addressBookList.countByCity("Akluj");
        Assertions.assertEquals(3, addressBookDataList.size());
    }

    @Test
    public void givenContactDataInDBwhenCountByStateShouldMatchRetrunTrue() {
        addressBookList = new AddressBookList();
        List<Contacts>  addressBookDataList = addressBookList.countByState("Mahatrashtra");
        Assertions.assertEquals(2, addressBookDataList.size());
    }

    @Test
    public void givenContactDataInDBwhenCountByStateShouldMatchReturnFalse() {
        addressBookList = new AddressBookList();
        List<Contacts>  addressBookDataList = addressBookList.countByState("AP");
        Assertions.assertEquals(2, addressBookDataList.size());
    }

    @Test
    public void givenNewContactDataWhenAddedShouldSyncWithDBReturnTrue() {
        addressBookList = new AddressBookList();
        addressBookContactList = addressBookList.readAddressBookData(AddressBookList.IOService.DB_IO);
        addressBookList.addContact("Sham", "Sai", "saimarag", "Solapur", "Maharashtra",
                253641, 9454526378L, "sham@gmail.com");
        boolean result = addressBookList.checkAddressBookInSyncWithDB("Sham");
        Assertions.assertTrue(result);
    }
}
