package com.addressbook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    private static AddressBook addressBook;

    public static AddressBook getInstance() {
        if (addressBook == null)
            addressBook = new AddressBook();
        return addressBook;
    }

    /* @Description - to stabilised connection to jdbc */

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_bookContact?useSSL=false";
        String userName = "root";
        String password = "root";
        Connection connection;
        System.out.println("Connecting to database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!" + connection);
        return connection;
    }

    /* @Description - To retrieve the data from database using sql statement  */

    public List<Contacts> getAddressBookDataUsingDB() {
        String sql = "SELECT * FROM address_book";
        List<Contacts> contacts = new ArrayList<>();
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            contacts = getAddressBookContactDataList(resultSet);
        } catch (SQLException e) {
            System.out.println("Data can not fetch from address book" +e);
            e.printStackTrace();
        }
        return contacts;
    }

    private List<Contacts> getAddressBookContactDataList(ResultSet resultSet) {
        List<Contacts> contacts = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
                long phoneNumber = resultSet.getLong("phoneNumber");
                String email = resultSet.getString("email");
                contacts.add(new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
