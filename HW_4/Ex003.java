package HW_4;

/*
В калькулятор добавьте возможность отменить последнюю операцию.
*/

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Ex003 {
    public static void main(String[] args) {
        Stack<Double> stack = new Stack<>();
        stack.push(0.0);
        boolean startApp = true;
        while (startApp) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
            
            / - деление
            * - умножение
            + - сложение
            - - вычитание
            cancel - отменить последнюю операцию
            exit - выход""");
            double firstNumber = stack.peek();
            System.out.print("\nТекущее число: " + firstNumber + "\nВыберите действие: ");
            String operator = scanner.nextLine();
            List<String> options = Arrays.asList("/", "*", "+", "-", "exit", "cancel");
            if (!options.contains(operator)) {
                System.out.printf("\nВы ввели '%s'. Такой операции нет.\n\n", operator);
            } else if (operator.equals("cancel")) {
                if (stack.size() > 1) {
                    stack.pop();
                } else {
                    System.out.println("\nНет операций для отмены\n");
                }
            } else if (operator.equals("exit")) {
                startApp = false;
                System.out.println("\nВсего доброго!\n");
            } else {
                System.out.print("\nВведите второе число: ");
                if (scanner.hasNextInt() || scanner.hasNextDouble()) {
                    double secondNumber = scanner.nextDouble();
                    if (secondNumber == 0 && operator.equals("/")) {
                        System.out.println("\nНа ноль делить нельзя!\n");
                    } else {
                        stack.push(makeOperation(firstNumber, operator, secondNumber));
                    }
                } else {
                    System.out.println("\nВводить можно только числа.\n");
                }
            }
        }
    }

    public static double makeOperation(Double firstNumber, String operator, Double secondNumber) {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> firstNumber / secondNumber;
        };
    }
}