package HW_3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/*
Реализовать алгоритм сортировки слиянием
 */

public class Ex001 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        int length = 10;
        fillArrayList(integers, length);
        System.out.println(integers);
        sortArrayList(integers);
        System.out.println(integers);
    }
    
    public static void fillArrayList(ArrayList<Integer> integers, int length) {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            integers.add(random.nextInt(100));
        }
        
    }

    public static ArrayList<Integer> sortArrayList(ArrayList<Integer> integers) {
        int length = integers.size();
        if (length == 1 || length == 0) {
            return integers;
        }
        ArrayList<Integer> left = sortArrayList(new ArrayList<Integer>(integers.subList(0, length/2)));
        ArrayList<Integer> right = sortArrayList(new ArrayList<Integer> (integers.subList(length/2, length)));
        int lenLeft = left.size();
        int lenRight = right.size();
        ArrayList<Integer> tempArrayList = new ArrayList<>(length);
        int n = 0;
        int m = 0;
        while (n < lenLeft && m < lenRight) {
            if (left.get(n) <= right.get(m)) {
                tempArrayList.add(left.get(n));
                n++;
            } else {
                tempArrayList.add(right.get(m));
                m++;
            }
        }
        while (n < lenLeft) {
            tempArrayList.add(left.get(n));
            n++;
        }
        while (m < lenRight) {
            tempArrayList.add(right.get(m));
            m++;
        }
        for (int i = 0; i < length; i++) {
            integers.set(i, tempArrayList.get(i));
        }

        return tempArrayList;
    }
    
}
