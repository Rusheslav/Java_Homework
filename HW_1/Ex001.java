// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

package HW_1;

import java.util.Scanner;

/**
 * Ex001
 */
public class Ex001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число n: ");
        int n = scanner.nextInt();
        while (true) {
            System.out.print("\nВыберите действие:\n1 - Посчитать сумму от 1 до n\n2 - Посчитать факториал (!n)\n0 - Выйти\n-: ");
            int choice = scanner.nextInt();
            System.out.println("");
            if (choice == 1) {
                System.out.println(sumNumbers(n));
                break;
            } else if (choice == 2) {
                System.out.println(getFactorial(n));
                break;
            } else if (choice == 0) {
                System.out.println("До скорых встреч!");
                break;
            } else {
                System.out.println("Необходимо выбрать число от 0 до 2");
            }
        }

        scanner.close();
    }

    private static int sumNumbers(int n) {
        return (n * (1 + n))/2;
    }

    private static int getFactorial(int n) {
        if (n == 1) {
            return n;
        } else {
            return n * getFactorial(n - 1);
        }
    }
}