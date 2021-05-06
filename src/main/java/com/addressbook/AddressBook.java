package com.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
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
    public static List<Contacts> contactsList = new ArrayList<>();
    public static HashMap<String, List<Contacts>> addressBookMap = new HashMap<>();
    /* @Description - Add new contacts to the address book  */

    public HashMap<String, List<Contacts>> addContacts(String addressBookName, Contacts contact) {
        try {
            if (!addressBookMap.containsKey(addressBookName)) {
                createNewAddAddressBook(addressBookName);
            }
            addressBookMap.get(addressBookName).add(contact);
            System.out.println("Address book is updated successfully.");
        } catch (Exception e) {
            System.out.println("Contact not added in address book "+ e);
            e.printStackTrace();
        }
        return addressBookMap;
    }

    /*Edit the contact details in address book.
    * Check a first name is match in address book then change details of that person.*/
    public Contacts editContacts(HashMap<String, List<Contacts>> addressBookList, String addressBookName, String name, String updateDetails) {
        try {
            if (addressBookList.containsKey(addressBookName)) {
                List<Contacts> contactsList = addressBookList.get(addressBookName);
            for(Contacts contact : contactsList) {
                if (contact.firstName.equals(name)) {
                    switch (name) {
                        case "firstName":
                            contact.firstName = updateDetails;
                            break;
                        case "lastName":
                            contact.lastName = updateDetails;
                            break;
                        case "address":
                            contact.address = updateDetails;
                            break;
                        case "city":
                            contact.city = updateDetails;
                            break;
                        case "state":
                            contact.state = updateDetails;
                            break;
                        case "zip":
                            contact.zip = Integer.parseInt(updateDetails);
                            break;
                        case "phoneNumber":
                            contact.phoneNumber = Long.parseLong(updateDetails);
                            break;
                        case "email":
                            contact.email = updateDetails;
                            break;
                    }
                    System.out.println("Address book is updated with first name of person" + name);
                }
                return true;
            }
            }
        } catch (Exception e) {
            System.out.println("Detail not found " + e);
            e.printStackTrace();
        }
        return false;
    }

    /*Delete a contact using person first name ina address book. */
    public List<Contacts> deleteContacts(HashMap<String, List<Contacts>> addressBookList, String addressBookName, String name) {
            try {
                if (addressBookList.containsKey(addressBookName)) {
                    List<Contacts> contactsList = addressBookList.get(addressBookName);
                for (Contacts contact : contactsList) {
                    if (contact.firstName.equals(name)) {
                        contactsList.remove(contactsList.indexOf(contact));
                        System.out.println("Enter a first name of person: " + name);
                        break;
                    }
                }
            }
            return contactsList;
        } catch (Exception e) {
            System.out.println("Enterd Name was not found in address book :" + e);
            e.printStackTrace();
        }
        return false;
    }

    /*Add new address book.*/
    public HashMap<String, List<Contacts>> createNewAddAddressBook(String addressBookName) {
        try {
            addressBookMap.put(addressBookName, new ArrayList<Contacts>());
            System.out.println("New Address Book Created with Name : " + addressBookName);
        } catch (Exception e) {
            System.out.println("Invalid name" + e);
            e.printStackTrace();
        }
        return addressBookMap;
    }

    /*Add Multiple contacts in address book. */
    public HashMap<String, List<Contacts>> addContactsList(String addressBookName, List<Contacts> contactDataList) {
        try {
            for (Contacts contact : contactDataList) {
                addContacts(addressBookName, contact);
            }
            return addressBookMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addressBookMap;
    }
}
