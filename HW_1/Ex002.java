// Вывести все простые числа от 1 до 1000

package HW_1;

public class Ex002 {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number == 2 || number == 3) {
            return true;
        } 
        if (number <= 1 || number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
