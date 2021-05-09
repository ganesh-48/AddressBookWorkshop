package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;

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
    public int indexValue = 1;
    public static List<Contacts> contactList = new ArrayList<>();
    public static HashMap<String, List<Contacts>> addressBookMap = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);
    static AddressBook addressbook = new AddressBook();

    public void selectOption() {
        int choice = 1;
        do {
            System.out.println("Enter your choice" +
                    "choice 1. Add Contact" +
                    "choice 2. Edit Contact" +
                    "choice 3. Delete Contact" +
                    "choice 4. Create New AddressBook" +
                    "choice 5. Search Person By City" +
                    "choice 6. Search Person By state" +
                    "choice 7. Exit");
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    addressbook.addContacts();
                    break;
                case 2:
                    addressbook.editContacts();
                    break;
                case 3:
                    addressbook.deleteContacts();
                    break;
                case 4:
                    addressbook.createNewAddressBook();
                    break;
                case 5:
                    addressbook.viewPersonByCity();
                    break;
                case 6:
                    addressbook.viewPersonByState();
                    break;
                case 7:
                    addressbook.countPersonByCity();
                    break;
                case 8:
                    addressbook.countPersonByState();
                    break;
                default:
                    System.out.println("Exit form address book");
                    choice = 9;
                    break;
            }
        }
        while (choice != 0);
    }



    /* @Description - Add new contacts to the address book  */

    private void addContacts() {
        System.out.println("Add no of persons");
        int numOfPerson = scanner.nextInt();
        for (int add = 1; add <= numOfPerson; add++) {
            System.out.println("enter the first name");
            String firstName = scanner.nextLine();
            System.out.println("enter the last name");
            String lastName = scanner.nextLine();
            System.out.println("enter the address");
            String address = scanner.nextLine();
            System.out.println("enter the state");
            String state = scanner.nextLine();
            System.out.println("enter the city");
            String city = scanner.nextLine();
            System.out.println("enter the zip code");
            int zip = scanner.nextInt();
            System.out.println("enter the phone number");
            long phoneNumber = scanner.nextLong();
            System.out.println("enter email");
            String email = scanner.next();
            if (addressbook.check(firstName)) {
                add--;
                continue;
            }
            Contacts contacts = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
            contacts.put(indexValue, contacts);
            indexValue++;
        }
        System.out.println("Contacts added Successfully");

    }

    private boolean checkDuplicate(HashMap<String, List<Contacts>> addressBookMap, String addressBookName, Contacts contact) {
        contactList = addressBookMap.get(addressBookName);
        long count = contactList.stream().filter(data -> data.firstName.equals(contact.firstName)).count();
        if (count == 0) return true;
        return false;
    }


    /*Edit the contact details in address book.
    * Check a first name is match in address book then change details of that person.*/
    public boolean editContacts() {

        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Enter the first name to edit contact.");
            String name = scanner.next();
            Iterator<Integer> itr = contacts.keySet().iterator();
            while (itr.hasNext()) {
                int key = itr.next();
                if (contacts.get(key).firstName.equals(name)) {
                    System.out.println("Enter First Name to Edit");
                    String first = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter Last Name to Edit");
                    String last = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter Address to Edit");
                    String address = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter City to Edit");
                    String city = scanner.nextLine();
                    System.out.println("Enter State to Edit");
                    String state = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter Zip  to Edit");
                    int zip = scanner.nextInt();
                    System.out.println("Enter Phone Number to Edit");
                    long phoneNumber = scanner.nextLong();
                    System.out.println("Enter email to Edit");
                    String email = scanner.next();
                    Contacts contact = new Contacts(first, last, address, city, state, zip, phoneNumer, email);
                    contact.put(key, contact);
                    System.out.println("Contact edited with given first name : " + name);
                }
            }
        }
        return  false;
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
            return addressBookMap;
        } catch (Exception e) {
            System.out.println("Enterd Name was not found in address book :" + e);
            e.printStackTrace();
        }
        return false;
    }

    /*Add new address book.*/
    public HashMap<String, List<Contacts>> createNewAddressBook(String addressBookName) {
        try {
            addressBookMap.put(addressBookName, new ArrayList<Contacts>());
            System.out.println("New Address Book Created with Name : " + addressBookName);
        } catch (Exception e) {
            System.out.println("Invalid name" + e);
            e.printStackTrace();
        }
        return addressBookMap;
    }

    /*Create a new address book*/
    public void createNewAddressBook() {
        System.out.println("Enter the name for Address Book");
        String addressBookName = sc.next();
        AddressBookList addressBookListobj = new AddressBookList(addressBookName);
    }

    /*Add Multiple contacts in address book. */
    public HashMap<String, List<Contacts>> addContactsList(String addressBookName, List<Contacts> contactDataList) {
        try {
            for (Contacts contact : contactDataList) {
                addContacts();
            }
            return addressBookMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addressBookMap;
    }

    /*view person by city*/
    public void viewPersonByCity() {
        System.out.println("Enter the city to View person.");
        String cityName = scanner.next();
        System.out.println("Person view by " + cityName);
        Collection<Contacts> values = Contacts.values();
        ArrayList<Contacts> conatactslist
                = new ArrayList<>(values);
        Dictionary dictWithCity = new Hashtable();
        conatactslist.stream().filter(n -> n.city.contains(cityName)).forEach(contactlist -> dictWithCity.put(contactlist.firstName, cityName));
        for (Enumeration i = dictWithCity.keys(); i.hasMoreElements(); ) {
            System.out.println(i.nextElement());
        }
    }

    /*View Person by state*/
    public void viewPersonByState() {
        System.out.println("Enter the state to view person.");
        String stateName = scanner.next();
        System.out.println("Person view by " + stateName);
        Collection<Contacts> values = contacts.values();
        ArrayList<Contacts> conatactslist
                = new ArrayList<>(values);
        Dictionary dictWithState = new Hashtable();
        conatactslist.stream().filter(n -> n.state.contains(stateName)).forEach(contactlist -> dictWithState.put(contactlist.firstName, stateName));
        for (Enumeration i = dictWithState.keys(); i.hasMoreElements(); ) {
            System.out.println(i.nextElement());
        }
    }

    /*  count  person by city name */
    public void countPersonByCity() {
        System.out.println("Enter the city to count person.");
        String stateName = scanner.next();
        String cityName;
        System.out.println("Person count by " + cityName);
        Collection<Contacts> values = contacts.values();
        ArrayList<Contacts> conatactlist = new ArrayList<>(values);
        System.out.println(conatactlist.stream().collect(Collectors.groupingBy((Contacts C) -> C.getCity(),Collectors.counting())));
    }

    /* count  person by state name */
    public void countPersonByState() {
        System.out.println("Enter the state to count person.");
        String stateName = scanner.next();
        System.out.println("Person count by " + stateName);
        Collection<Contacts> values = contacts.values();
        ArrayList<Contacts> conatactlist = new ArrayList<>(values);
        System.out.println(conatactlist.stream().collect(Collectors.groupingBy((Contacts C) -> C.getState(),Collectors.counting())));
    }
}
