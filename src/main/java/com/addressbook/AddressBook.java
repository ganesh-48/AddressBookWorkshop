package com.addressbook;

import java.util.ArrayList;
import java.util.List;

/*@Description-Creating a Address Book.
* Welcome to address book.
* Contacts are created.
* Add a new contacts into a address book. */
public class AddressBook {
    public List<Contacts> contactList;

    /* @Description - Add new contacts to the address book  */

    public boolean addContacts(Contacts contacts) {
        System.out.println(contacts);
        List<Contacts> contactList = new ArrayList<>();
        try {
            contactList.add(contacts);
            System.out.println(contactList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
