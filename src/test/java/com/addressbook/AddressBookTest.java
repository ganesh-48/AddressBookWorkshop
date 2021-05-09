package com.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class AddressBookTest {
    private static String HOME = System.getProperty("C:\\Users\\Ganesh\\CsvReader\\AddressBookIO");
    private static String checkContacts = "Contact Details";

    @Test
    public void givenPathWhenCheckedThenConfirmTrue() throws IOException {
        System.out.println(HOME);
        Path homePath = Paths.get(HOME);
        Assertions.assertTrue(Files.exists(homePath));

        Path path = Paths.get(HOME + "/" + checkContacts);
        if (Files.exists(path)) Files.delete(path);
        Assertions.assertTrue(Files.notExists(path));
        Files.createDirectories(path);
        Assertions.assertTrue(Files.exists(path));
        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(path + "/temp" + cntr);
            Assertions.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
            }
            Assertions.assertTrue(Files.exists(tempFile));
        });

        Files.list(path).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(path).forEach(System.out::println);
        Files.newDirectoryStream(path, path1 -> path.toFile().isFile() && path
                .toString().startsWith("temp")).forEach(System.out::println);
    }


}
