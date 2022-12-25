package HW_5;

/*
Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов

Написать программу, которая найдет и выведет
повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности.
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Ex002 {
    public static void main(String[] args) throws FileNotFoundException {
        Ex002 task = new Ex002();
        Map<String, Integer> book = task.getMap("names.txt");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(book.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        list.forEach(System.out::println);
    }

    public Map<String, Integer> getMap(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            Scanner scanner = new Scanner(fr);
            Map<String, Integer> book = new HashMap<>();
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine().split(" ")[0];
                if (!book.containsKey(name)) {
                    book.put(name, 1);
                } else {
                    Integer numOfRepeats = book.get(name);
                    book.put(name, numOfRepeats + 1);
                }
            }
            return book;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
