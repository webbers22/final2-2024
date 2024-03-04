import java.util.*;
class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, Set<String>> phoneBook = new HashMap<>();

        // Добавляем записи в телефонную книгу
        addContact(phoneBook, "Pivovarov", "1234567890");
        addContact(phoneBook, "Bochkarev", "9876543210");
        addContact(phoneBook, "Nevinny", "5678901234");
        addContact(phoneBook, "Pivovarov", "5678454561234");
        addContact(phoneBook, "Bochkarev", "56456901234");
        addContact(phoneBook, "Brajnikov", "56789456234");
        addContact(phoneBook, "Bochkarev", "5678901234");
        addContact(phoneBook, "Razgulyaev", "56784641234");

        // Выводим телефонную книгу
        printPhoneBook(phoneBook);

        // Выводим отсортированные записи по убыванию числа телефонов
        printSortedPhoneBook(phoneBook);
    }

    public static void addContact(HashMap<String, Set<String>> phoneBook, String name, String phoneNumber) {
        Set<String> numbers = phoneBook.getOrDefault(name, new HashSet<>());
        numbers.add(phoneNumber);
        phoneBook.put(name, numbers);
    }

    public static void printPhoneBook(HashMap<String, Set<String>> phoneBook) {
        System.out.println("Телефонная книга:");
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void printSortedPhoneBook(HashMap<String, Set<String>> phoneBook) {
        System.out.println("\nТелефонная книга (отсортированная по убыванию числа телефонов):");
        phoneBook.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}