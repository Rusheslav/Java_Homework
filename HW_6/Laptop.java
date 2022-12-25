package HW_6;

/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
*/

import java.util.ArrayList;
import java.util.Objects;

public class Laptop {

    public String brand;
    public String model;
    public String color;
    public String operationSystem;
    public double screenSize;
    public double processor;
    public int memory;
    public int storage;
    public String serialNumber;
    public ArrayList<Store> stores;

    public Laptop(String brand, String model, String color, String operationSystem,
                  double screenSize, double processor, int memory, int storage, String serialNumber, ArrayList<Store> stores) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.operationSystem = operationSystem;
        this.screenSize = screenSize;
        this.processor = processor;
        this.memory = memory;
        this.storage = storage;
        this.serialNumber = serialNumber;
        this.stores = stores;
    }

    public void showStores() {
        StringBuilder allStores = new StringBuilder();
        for (Store store: stores) {
            allStores.append("\n" + store.name);
        }
        System.out.println("\n Товар доступен в следующих магазинах: ");
    }

    @Override
    public String toString() {
        return String.format("""
                
                Производитель: %s
                Модель: %s
                Цвет: %s
                Операционная система: %s
                Диагональ экрана: %s
                Частота процессора: %s
                Оперативная память: %d
                Общий объём накопителей: %d
                Серийный номер: %s
                """, brand, model, color, operationSystem,
                screenSize, processor, memory, storage,
                serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, color, operationSystem,
                screenSize, processor, memory, storage,
                serialNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Laptop) {
            Laptop laptop = (Laptop) obj;
            if (obj.hashCode() != this.hashCode()) {
                return false;
            }
            if (this.serialNumber.equals(laptop.serialNumber) && model.equals(laptop.model)) {
                return true;
            }
        }
        return false;
    }
}
