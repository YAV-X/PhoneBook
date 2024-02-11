import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();


        addContact(phoneBook, "Иванов А", "123456789");
        addContact(phoneBook, "Петров И", "987654321");
        addContact(phoneBook, "Петров И", "777777777");
        addContact(phoneBook, "Сидоров C", "555555555");
        addContact(phoneBook, "Иванов А", "999888777");
        addContact(phoneBook, "Петров И", "111222333");
        addContact(phoneBook, "Иванов В", "111222333");


        printPhoneBook(phoneBook);
    }


    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.putIfAbsent(name, new HashSet<>());
        phoneBook.get(name).add(phoneNumber);
    }


    public static void printPhoneBook(Map<String, Set<String>> phoneBook) {
        // Создаем список записей телефонной книги
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем список по убыванию числа телефонов у каждого контакта
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            String name = entry.getKey();
            Set<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}