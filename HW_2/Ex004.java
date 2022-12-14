package HW_2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
К калькулятору из предыдущего дз добавить логирование.
 */

public class Ex004 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Ex004.class.getName());
        FileHandler fh = new FileHandler("calc.log", true);
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            int numberOne = scanner.nextInt();
            System.out.print("\nВведите второе число: ");
            int numberTwo = scanner.nextInt();
            System.out.print("\nВведите операцию: ");
            char operation = scanner.next().charAt(0);
            if (operation == '+') {
                System.out.println("\nРезультат: " + (numberOne + numberTwo));
                logger.log(Level.INFO, "Пользователь сложил два числа " + numberOne + " и " + numberTwo + 
                ". Получилось " + (numberOne + numberTwo));
            } else if (operation == '-') {
                System.out.println("\nРезультат: " + (numberOne - numberTwo));
                logger.log(Level.INFO, "Пользователь вычел " + numberTwo + " из " + numberOne + 
                ". Получилось " + (numberOne - numberTwo));
            } else if (operation == '*') {
                System.out.print("\nРезультат: " + (numberOne * numberTwo));
                logger.log(Level.INFO, "Пользователь умножил " + numberOne + " на " + numberTwo + 
                ". Получилось " + (numberOne * numberTwo));
            } else if (operation == '/') {
                if (numberTwo != 0) {
                    int remainder = numberOne % numberTwo;
                    int divResult = numberOne / numberTwo;
                    if (remainder == 0) {
                        System.out.println("\nРезультат: " + divResult);
                        logger.log(Level.INFO, "Пользователь разделил " + numberOne + " на " + numberTwo + 
                        ". Получилось " + (divResult));
                    } else {
                        System.out.println("\nРезультат: " + (double)numberOne/(double)numberTwo);
                        logger.log(Level.INFO, "Пользователь разделил " + numberOne + " на " + numberTwo + 
                        ". Получилось " + (double)numberOne/(double)numberTwo);
                    }
                } else {
                    System.out.println("\nИ чем это мы тут занимаемся? НА НОЛЬ ДЕЛИМ?!?");
                    logger.log(Level.INFO, "Пользователь шалун. Он пытался поделить на ноль. Ничего не вышло!");
                }
            } else {
                System.out.println("\nНеизвестная операция");
                logger.log(Level.INFO, "Пользователь пытался выполнить неизвестную опеацию - " + operation);
            }
            scanner.close();
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Ошибка: " + ex);
        }
    }
}
