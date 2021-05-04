package com.addressbook;

/*@Description-Creating a Address Book.
* Welcome to address book.
* Contacts are created. */
public class AddressBook {
    public static void main(String[] args) {
        System.out.println("Welcome to address book");

        Contacts contact = new Contacts("Ram", "Sharma", "Line - 3", "maharashtra", "solapur", 123456, 1234567899, "abc@gmail.com");
        System.out.println(contact.toString());
    }
}
