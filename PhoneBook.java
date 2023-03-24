// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 
// 1) Добавление номера
// 2) Вывод всего

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class PhoneBook {
    private Map<String, List<String>> contacts;
    private Scanner scanner;
    

    public PhoneBook() {
        contacts = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void addContact(String name, String phoneNumber) {
        List<String> phoneNumbers = contacts.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        contacts.put(name, phoneNumbers);
    }

    public void printContacts() {
        System.out.println("Контакты:");
        for (String name : contacts.keySet()) {
            System.out.print(name + ": ");
            List<String> phoneNumbers = contacts.get(name);
            for (String phoneNumber : phoneNumbers) {
                System.out.print(phoneNumber + " ");
            }
            System.out.println();
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Вывести все контакты");
            System.out.println("3. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите номер телефона: ");
                    String phoneNumber = scanner.nextLine();
                    addContact(name, phoneNumber);
                    break;
                case 2:
                    printContacts();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }
}
