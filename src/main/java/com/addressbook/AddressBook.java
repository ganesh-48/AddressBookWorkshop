package com.addressbook;

import java.util.ArrayList;
import java.util.List;

/*@Description-Creating a Address Book.
* Welcome to address book.
* Contacts are created.
* Add a new contacts into a address book.
* Edit the contact details in address book.
* Check a first name is match in address book then change details of that person.
* Delete a contact using person first name ina address book.
* Add Multiple contacts in address book.
* Return the data contact list.*/
public class AddressBook {
    public List<Contacts> contactList;

    /* @Description - Add new contacts to the address book  */

    public List<Contacts> addContacts(Contacts contact) {
        contactList = new ArrayList<>();
        try {
            contactList.add(contact);
            return contactList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactList;
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

    /*Delete a contact using person first name ina address book. */
    public List<Contacts> deleteContacts(List<Contacts> contactsList, String firstName) {
        try {
            for (Contacts contact : contactsList) {
                if (contact.firstName.equals(firstName)) {
                    contactsList.remove(contactsList.indexOf(contact));
                    System.out.println("Enter a first name of person: " +firstName);
                    break;
                }
            }
            return contactsList;
        } catch (Exception e) {
            System.out.println("Enterd Name was not found in address book :" +e);
            e.printStackTrace();
        }
        return contactsList;
    }

    /*Add Multiple contacts in address book. */
    public List<Contacts> addMultipleContactsList(List<Contacts> contactDataList) {
        try {
            for (Contacts contacts : contactDataList) {
                addContacts(contacts);
            }
            return contactList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactDataList;
    }
}
