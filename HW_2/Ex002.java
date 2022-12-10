package HW_2;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
Реализуйте алгоритм сортировки пузырьком числового массива,
результат после каждой итерации запишите в лог-файл.
 */

public class Ex002 {
    public static void main(String[] args) {
        Random random = new Random();
        int arrLength = 10;
        int[] arrRand = new int[arrLength];
        fillArray(arrRand, random);
        System.out.println(Arrays.toString(arrRand));
        sortArray(arrRand);
        System.out.println(Arrays.toString(arrRand));
    }
    
    public static void fillArray(int[] array, Random rand) {
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
    }
    
    public static void sortArray(int[] array) {
        Logger logger = Logger.getLogger(Ex002.class.getName());
        try {
            FileHandler fh = new FileHandler("log.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Что-то пошло не так.");
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    logger.log(Level.INFO, Arrays.toString(array));
                }   
            }
        }
    }
}
