/*  *+Задано уравнение вида q + w = e, q, w, e >= 0. 
Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
Требуется восстановить выражение до верного равенства. 
Предложить хотя бы одно решение или сообщить, что его нет. */

package HW_1;

import java.util.Scanner;

public class Ex004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] expr = scanner.nextLine().split(" ");
        String numOne = expr[0];
        String numTwo = expr[2];
        String numThree = expr[4];
        System.out.println(getAnswer(numOne, numTwo, numThree));
        scanner.close();
    }

    public static int getNum(String num, int n) {
        int result = 0;
        int length = num.length();
        for (int i = 0; i < length; i++) {
            int pow = (int)(Math.pow(10, (length - i - 1)));
            if (num.charAt(i) == '?') {
                result += n * pow;
            } else {
                result += Character.getNumericValue(num.charAt(i)) * pow;
            }
        }
        return result;
    }

    public static String getAnswer(String numOne, String numTwo, String numThree) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                int numberOne = getNum(numOne, x);
                // System.out.println(numberOne);
                int numberTwo = getNum(numTwo, y);
                // System.out.println(numberTwo);
                if (numberOne + numberTwo == Integer.valueOf(numThree)) {
                    return numberOne + " + " + numberTwo + " = " + numThree;
                }
            }
        }
        return "Таких значений нет";
    }
}
