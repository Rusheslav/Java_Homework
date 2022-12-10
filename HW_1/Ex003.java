// Реализовать простой калькулятор

package HW_1;

import java.util.Scanner;

public class Ex003 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Введите первое число: ");
        int numberOne = scanner.nextInt();
        System.out.print("\nВведите второе число: ");
        int numberTwo = scanner.nextInt();
        System.out.print("\nВведите операцию: ");
        char operation = scanner.next().charAt(0);
        if (operation == '+') {
            System.out.println("\nРезультат: " + (numberOne + numberTwo));
        } else if (operation == '-') {
            System.out.println("\nРезультат: " + (numberOne - numberTwo));
        } else if (operation == '*') {
            System.out.print("\nРезультат: " + (numberOne * numberTwo));
        } else if (operation == '/') {
            int remainder = numberOne % numberTwo;
            int divResult = numberOne / numberTwo;
            if (remainder == 0) {
                System.out.println("\nРезультат: " + (divResult));
            } else {
                int GCD = getGCD(remainder, numberTwo);
                System.out.println("\nРезультат: " + (divResult != 0 ? divResult + " " : "") + (remainder/GCD) + "/" + (numberTwo/GCD));
            }
        } else {
            System.out.println("\nНеизвестная операция");
        }
    }

    public static int getGCD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }
}
