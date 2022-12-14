package HW_3;

/*
Задан целочисленный список ArrayList.
Найти минимальное, максимальное и среднее из этого списка.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ex003 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        int length = 9;
        fillArrayList(integers, length);
        System.out.println(integers);
        int minNum = Collections.min(integers);
        int maxNum = Collections.max(integers);
        int medNum = findMedian(integers, length);
        System.out.println(integers);
        System.out.println(String.format("Min -> %d\nMax -> %d\nMed -> %d", minNum, maxNum, medNum));
    }


    public static void fillArrayList(ArrayList<Integer> integers, int length) {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            integers.add(random.nextInt(100));
        }
    }

    public static int findMedian(ArrayList<Integer> integers, int length) {
        Collections.sort(integers);
        return integers.get(length/2);
    }
}
