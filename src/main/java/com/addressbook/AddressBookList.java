package com.addressbook;

import java.util.List;

public class AddressBookList {
    public enum IOService {
        DB_IO
    }

    private List<Contacts> addressBookList;
    public AddressBook addressBook;

    public AddressBookList() {
        addressBook = AddressBook.getInstance();
    }

    public  AddressBookList(List<Contacts> addressBookList) {
        this();
        this.addressBookList = addressBookList;
    }

    public List<Contacts> readAddressBookData(IOService ioService) {
        if (ioService.equals(IOService.DB_IO))
            return this.addressBookList = addressBook.getAddressBookDataUsingDB();
        return null;

    }

}
