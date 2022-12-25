package HW_5;

import java.util.*;

/*
Реализуйте структуру телефонной книги с помощью HashMap,
учитывая, что 1 человек может иметь несколько телефонов.
*/
public class Ex001 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> phoneBook = new HashMap<String, ArrayList<String>>();
        phoneBook.put("Иванов Иван", new ArrayList<String>(Arrays.asList("123", "345")));
        phoneBook.put("Петров Петр", new ArrayList<String>(Arrays.asList("456", "789")));
        phoneBook.put("Мариева Мария", new ArrayList<String>(Arrays.asList("987", "654")));
        Ex001 task = new Ex001();
        boolean startApp = true;
        while (startApp) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("""
                    
                    1 - Вывести книгу
                    2 - Добавить контакт
                    0 - Выйти
                    
                    Введите команду:""");
            String command = scanner.nextLine();
            switch (command) {
                case "1" -> task.showBook(phoneBook);
                case "2" -> task.addRecord(phoneBook);
                case "0" -> {
                    System.out.println("\nДо скорых встреч!");
                    startApp = false;
                }
                default -> System.out.println("\nНеизвестная команда\n");
            }
        }
    }


    public void showBook(Map<String, ArrayList<String>> book) {
        System.out.println();
        for (String contact : book.keySet()) {
            System.out.printf("%s --> %s\n", contact, book.get(contact).toString());
        }
    }

    public void addRecord(Map<String, ArrayList<String>> book) {
        System.out.print("\nВведите фамилию и имя нового контакта: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        boolean newPhone = true;
        while (newPhone) {
            System.out.print("Введите телефон контакта или пустой ввод, чтобы не вводить номер\n" +
                    "Если вы не ввели ни одного номера, контакт не будет создан: ");
            String phoneNumber = scanner.nextLine();
            if (!phoneNumber.equals("")) {
                if (!book.containsKey(name)) {
                    book.put(name, new ArrayList<String>(List.of(phoneNumber)));
                } else {
                    ArrayList<String> temp = book.get(name);
                    temp.add(phoneNumber);
                    book.put(name, temp);
                }
            } else {
                newPhone = false;
            }
        }
    }
}
