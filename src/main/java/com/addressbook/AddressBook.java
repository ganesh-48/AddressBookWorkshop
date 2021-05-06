package com.addressbook;

import java.util.ArrayList;
import java.util.List;

/*@Description-Creating a Address Book.
* Welcome to address book.
* Contacts are created.
* Add a new contacts into a address book.
* Edit the contact details in address book.
* Check a first name is match in address book then change details of that person. */
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

    /*Edit the contact details in address book.
    * Check a first name is match in address book then change details of that person.*/
    public Contacts editContacts(List<Contacts> contactList, String firstName, String name, String editDetails) {
        try {
            for(Contacts contact : contactList){
                if(contact.firstName.equals(name)) {
                    switch (name) {
                        case "firstName":
                            contact.firstName = editDetails;
                            break;
                        case "lastName":
                            contact.lastName = editDetails;
                            break;
                        case "address":
                            contact.address = editDetails;
                            break;
                        case "city":
                            contact.city = editDetails;
                            break;
                        case "state":
                            contact.state = editDetails;
                            break;
                        case "zip":
                            contact.zip = Integer.parseInt(editDetails);
                            break;
                        case "phoneNumber":
                            contact.phoneNumber = Long.parseLong(editDetails);
                            break;
                        case "email":
                            contact.email = editDetails;
                            break;
                    }
                }
                return contact;
            }
        } catch (Exception e) {
            System.out.println("Detail not found " + e);
            e.printStackTrace();
        }
        return null;
    }
}
