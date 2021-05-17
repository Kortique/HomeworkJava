package geekbrains.hm11;

import java.util.*;

public class PhoneBook {

    Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    Set<String> get(String name) {
        return getPhones(name);
    }

    Set<String> getNames() {
        return phoneBook.keySet();
    }

    void addPhones(String name, String number) {
        Set<String> phones = getPhones(name);
        phones.add(number);
    }

    private Set<String> getPhones (String name) {
        Set<String> phones = phoneBook.getOrDefault(name, new HashSet<>());
        if (phones.isEmpty()) {
            phoneBook.put(name, phones);
        }

        return phones;
    }


}