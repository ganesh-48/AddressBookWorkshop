package com.addressbook;

import com.google.gson.*;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

;

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
* Search person by state.
* Read or write a  address book with person contact as JSON file.*/

public class AddressBook {

    private static final String HOME = System.getProperty("user.dir");
    private static final String fileName = "AddressBook.json";
    private static final Path homePath = Paths.get(HOME);
    public static final Gson gson = new GsonBuilder().create();

    /* @Description - To write  the contacts details. */
    public static boolean jsonWrite(Contacts contacts) {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {
                if (Files.exists(filePath)) {
                    String s = gson.toJson(contacts);
                    FileWriter fileWriter = new FileWriter(String.valueOf(filePath));
                    fileWriter.write(s);
                    fileWriter.close();
                    return true;
                } else {
                    Files.createFile(filePath);
                    String s = gson.toJson(contacts);
                    FileWriter fileWriter = new FileWriter(String.valueOf(filePath));
                    fileWriter.write(s);
                    fileWriter.close();
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }
    /* @Description - To read the contacts details. */

    public static boolean jsonRead() {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {
                if (Files.exists(filePath)) {
                    BufferedReader br = new BufferedReader(
                            new FileReader(String.valueOf(filePath)));
                    Contacts contactPerson = gson.fromJson(br, Contacts.class);
                    System.out.println("ContactAddressBookPerson{" + "firstName='" + contactPerson.firstName + '\'' + ", lastName='" + contactPerson.lastName + '\'' + ", address='" + contactPerson.address + '\'' + ", city='" + contactPerson.city + '\'' + ", state='" + contactPerson.state + '\'' + ", zip=" + contactPerson.zip + ", mobileNumber='" + contactPerson.phoneNumber + '\'' + ", email='" + contactPerson.email + '\'' + '}' );
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        }
        return true;

    }

}
