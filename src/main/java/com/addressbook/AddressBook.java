package com.addressbook;

import java.util.*;

/*@Description-Creating a Address Book.
* Welcome to address book.
* Contacts are created.
* Add a new contacts into a address book.
* Edit the contact details in address book.
* Check a first name is match in address book then change details of that person.
* Delete a contact using person first name ina address book.
* Add Multiple contacts in address book.
* Return the data contact list.
* Check a duplicate entry of same person in address book.
* Search person by city.
* Search person by state.*/

public class AddressBook {
    private static List<Contacts> addressBookContactsList;
    public AddressBook(List<Contacts> addressBookContactsList) {
        this.addressBookContactsList = addressBookContactsList;
    }

    /* @Description - to write the contacts details */

    private static void writeAddressBookContactsData(Scanner consoleInputReader) {
        System.out.println("Enter first name: ");
        String firstName = consoleInputReader.nextLine();
        System.out.println("Enter last name: ");
        String lastName = consoleInputReader.nextLine();
        System.out.println("Enter address: ");
        String address = consoleInputReader.nextLine();
        System.out.println("Enter city name: ");
        String city = consoleInputReader.nextLine();
        System.out.println("Enter state name: ");
        String state = consoleInputReader.nextLine();
        System.out.println("Enter zip: ");
        int  zip = consoleInputReader.nextInt();
        System.out.println("Enter zip: ");
        long  phoneNumber = consoleInputReader.nextLong();
        System.out.println("Enter email: ");
        String emailId = consoleInputReader.nextLine();

    }

    /* @Description - to read  the  contacts details. */
    private static void readAddressBookContactsData() {
        System.out.println("Write Address Book contacts details " + addressBookContactsList);
    }

    public static void main(String[] args) {
        Scanner consoleInputReader = new Scanner(System.in);
        AddressBook.writeAddressBookContactsData(consoleInputReader);
        AddressBook.readAddressBookContactsData();

    }

}
