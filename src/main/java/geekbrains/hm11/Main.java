package geekbrains.hm11;

import java.util.HashMap;
import java.util.Set;

public class Main {



    public static void main(String[] args) {

        getCountOfElements();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhones("Базилевс", "8008008008");
        phoneBook.addPhones("Акукарача", "9009009009");
        phoneBook.addPhones("Базилевс", "7007007007");

        getContactOfPhoneBook(phoneBook);


    }

    private static void getContactOfPhoneBook(PhoneBook phoneBook) {
        Set<String> names = phoneBook.getNames();
        for (String name: names) {
            Set<String> phone = phoneBook.get(name);
            System.out.printf("%s: %s%n", name, phone);
        }
    }

    private static void getCountOfElements() {
        String[] array = {"123", "321", "zxc", "cxz", "zxc", "123", "321", "qwe",
                "ewq", "qwe", "cxz", "456", "123", "cxz", "asd", "cxz", "321", "dsa", "asd"};

        HashMap<String, Integer> table = new HashMap<>();

        for (String element : array) {
            table.put(element, table.getOrDefault(element, 0) + 1);
        }

        System.out.println(table);
    }


}
