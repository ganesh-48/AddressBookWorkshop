package com.addressbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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

    public static void writeCsv(String filePath) {
        List<Contacts> contacts = new ArrayList<Contacts>();
        Contacts contactDataList = new Contacts(filePath, filePath, filePath, filePath, filePath, filePath, filePath, filePath, filePath);
        contactDataList.setFirstName("Ram");
        contactDataList.setLastName("Sharma");
        contactDataList.setAddress("Line-3");
        contactDataList.setCity("Solapur");
        contactDataList.setState("Maharashtra");
        contactDataList.setZip(123456);
        contactDataList.setPhoneNumber(1234567899L);
        contactDataList.setEmail("abc@gmail.com");
        contacts.add(contacts);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.append("firstName,lastName,address,city,state,zip,phoneNumber,Email");
            for (Contacts contacts : contacts) {
                fileWriter.append(String.valueOf(contacts.getFirstName()));
                fileWriter.append(String.valueOf(contacts.getLastName()));
                fileWriter.append(String.valueOf(contacts.getAddress()));
                fileWriter.append(String.valueOf(contacts.getCity()));
                fileWriter.append(String.valueOf(contacts.getState()));
                fileWriter.append(String.valueOf(contacts.getZip()));
                fileWriter.append(String.valueOf(contacts.getPhoneNumber()));
                fileWriter.append(String.valueOf(contacts.getEmail()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void readCsv(String filePath) {
        BufferedReader reader = null;
        try {
            List<Contacts> employeeContacts = new ArrayList<Contacts>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();
            while (( reader.readLine() != null)) {
                String[] field = line.split(",");
                if (!(field.length() <= 0)) {
                    Contacts contacts = new Contacts(field, field, field, field, field, field, field, field, field);
                    contacts.setFirstName("Prahlad");
                    contacts.setLastName("Prajapati");
                    contacts.setAddress("Azamgarh");
                    contacts.setCity("Azamgarh");
                    contacts.setState("up");
                    contacts.setZip(223223);
                    contacts.setPhoneNumber(8052636931l);
                    contacts.setEmail("amarprajapati99@gmail.com");
                    contacts.add(contacts);
                }
            }
            for (Contacts addressBook : employeeContacts) {
                System.out.printf(
                        "First Name = %s,Last Name = s, Address = %s, City = %s, State = %s,Zip = %s,Phone Number = %s,Email = %s",
                        addressBook.getFirstName(), addressBook.getLastName(), addressBook.getAddress(), addressBook.getCity(), addressBook.getState(), addressBook.getZip(),
                        addressBook.getPhoneNumber(), addressBook.getEmail());
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Ganesh\\CsvReader\\AddressBookIO";
        System.out.println("Starting File writing :" + filePath);
        writeCsv(filePath);
        System.out.println("starting read file");
        readCsv(filePath);

    }
}
