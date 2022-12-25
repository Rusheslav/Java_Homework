package HW_6;

import java.util.*;

public class Task {
    public static void main(String[] args) {
        Task task = new Task();
        Store nikitskaya = new Store("Re:Store на Никитской", "Никитский бул., 10", "Пн-вс",
                new Integer[]{0, 0, 23, 59});
        Store shabolovskaya = new Store("Re:Store на Шаболовской", "Шаболовская ул., 11",
                "Пн-пт", new Integer[]{9, 0, 21, 0});
        Store prMira = new Store("Эльдорадо на Пр. Мира", "Проспект мира, 103", "Пн-сб",
                new Integer[]{7, 0, 23, 0});

        Laptop macBook = new Laptop("Apple", "MacBook", "grey", "macOS Monterey",
                13.0, 1.6, 8, 256, "QWRQWQWRQR103Q",
                new ArrayList<>(List.of(nikitskaya, shabolovskaya, prMira)));
        Laptop hp = new Laptop("HP", "G8", "black", "Windows 10 Pro",
                15.6, 2.4, 8, 256, "QWRQWQWRQR103Q",
                new ArrayList<>(List.of(shabolovskaya, prMira)));
        Laptop asus = new Laptop("Asus", "Zen", "black", "Windows 11",
                14.0, 2.0, 8, 512, "QWRQWQWRQR103Q",
                new ArrayList<>(List.of(nikitskaya, prMira)));

        HashSet<Laptop> setLaptops = new HashSet<>(List.of(macBook, hp, asus));

        while (true) {
            double screenSize = task.getInput("диагонали экрана");
            double processor = task.getInput("частоты процессора");
            double memory = task.getInput("опреативной памяти");
            double storage = task.getInput("общего объёма накопителей");

            HashMap<String, Double> filters = new HashMap<>();
            filters.put("screenSize", screenSize);
            filters.put("processor", processor);
            filters.put("memory", memory);
            filters.put("storage", storage);

            HashSet<Laptop> filteredSet = new HashSet<>();
            for (Laptop laptop : setLaptops) {
                if (laptop.screenSize >= filters.get("screenSize") && laptop.processor >= filters.get("processor")
                && laptop.memory >= filters.get("memory") && laptop.storage >= filters.get("storage")) {
                    filteredSet.add(laptop);
                }
            }

            if (!filteredSet.isEmpty()) {
                System.out.println("\nВот, что нашлось:\n");
                for (Laptop laptop : filteredSet) {
                    System.out.println(laptop);
                }
            } else {
                System.out.println("Ничего не нашлось");
            }
        }
    }

    public double getInput(String text) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("\nВведите минимальное значение %s (0 - чтобы пропустить фильтр, exit - чтобы выйти): ",
                    text);

            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                if (scanner.nextLine().equals("exit")) {
                    System.out.println("\nДо новых встреч!");
                    System.exit(0);
                }
                    System.out.println("\nВводить можно только цифры!");
            }
        }
    }

}