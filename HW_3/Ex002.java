package HW_3;

import java.util.ArrayList;
import java.util.Random;

/*
Пусть дан произвольный список целых чисел, удалить из него четные числа
 */

public class Ex002 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        int length = 10;
        fillArrayList(integers, length);
        System.out.println(integers);
        removeEven(integers);
        System.out.println(integers);
    }

    public static void fillArrayList(ArrayList<Integer> integers, int length) {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            integers.add(random.nextInt(100));
        }
    }
    
    public static void removeEven(ArrayList<Integer> integers) {
        integers.removeIf(n -> (n%2 == 0));
    }
}
