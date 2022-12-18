package HW_4;

/*
Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.
(Подобную задачу решали на семинаре. Здесь так же нужно создать класс, который будет реализовывать указанные методы)
*/

import java.util.LinkedList;
import java.util.Scanner;

public class Ex002 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean startApp = true;
        LinkedList<String> list = new LinkedList<String>();
        while (startApp) {
            if (list.size() != 0) {
                System.out.println("\n" + list + "\n");
            } else {
                System.out.println("\nСписок пуст\n");
            }
            System.out.print("""
                    1 - Поместить элемент в конец
                    2 - Вывести первый элемент из очереди и удалить его
                    3 - Вывести первый элемент из очереди
                    0 - Выйти
                    
                    Введите команду:""");
            String command = scanner.nextLine();
            switch (command) {
                case "1" -> enqueue(list);
                case "2" -> dequeue(list);
                case "3" -> first(list);
                case "0" -> {
                    System.out.println("\nДо скорых встреч!");
                    startApp = false;
                }
                default -> System.out.println("\nНеизвестная команда\n");
            }
        }
    }

    public static void enqueue(LinkedList<String> list) {
        System.out.print("\nВведите элемент для записи в конец: ");
        String input = scanner.nextLine();
        list.addLast(input);
    }

    public static void dequeue(LinkedList<String> list) {
        if (list.size() > 0) {
        System.out.println("\nПервый элемент: " + list.removeFirst());
        } else {
            System.out.println("\nСписок пуст. Невозможно вывести элемент\n");
        }
    }

    public static void first(LinkedList<String> list) {
        if (list.size() > 0) {
            String firstElement = list.getFirst();
            System.out.println("\nПервый элемент: " + firstElement);
        } else {
            System.out.println("\nСписок пуст. Невозможно вывести элемент\n");
        }
    }
}