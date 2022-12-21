package HW_4;

/*
Пусть дан LinkedList с несколькими элементами.
Реализуйте метод, который вернет “перевернутый” список.
*/

import java.util.LinkedList;

public class Ex001 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        fillList(list);
        System.out.println(list);
        reverseList(list);
        System.out.println(list);
    }

    public static void fillList(LinkedList<Integer> list) {
        for (int i = 1; i <= 11; i++) {
            list.offer(i);
        }
    }

    public static void reverseList(LinkedList<Integer> list) {
        int length = list.size();
        for (int i = 0; i < length/2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(length-1-i));
            list.set(length-1-i, temp);
        }
    }
}
