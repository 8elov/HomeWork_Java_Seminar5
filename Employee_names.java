// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.

import java.util.*;

public class Employee_names {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов");

        Map<String, Integer> counts = new HashMap<>();

        for (String name : employees) {
            String[] parts = name.split(" ");
            String firstName = parts[0];
            counts.put(firstName, counts.getOrDefault(firstName, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedCounts = new ArrayList<>(counts.entrySet());

        sortedCounts.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        for (Map.Entry<String, Integer> entry : sortedCounts) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
