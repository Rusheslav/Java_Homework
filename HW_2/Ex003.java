package HW_2;

import java.io.FileReader;
import java.util.Scanner;

/*
Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder,
создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
*/

public class Ex003 {
    public static void main(String[] args) throws Exception {
        String data = getFromFile("jsonString.txt");
        String[] arrData = getArray(data);
        StringBuilder result = getResult(arrData);
        System.out.println(result);
    }
    
    public static String getFromFile(String fileName) throws Exception {
        FileReader fr = new FileReader(fileName);
        Scanner scanner = new Scanner(fr);
        StringBuilder resultStringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            resultStringBuilder.append(scanner.nextLine());
        }
        fr.close();
        scanner.close();
        return resultStringBuilder.toString();
    }
    
    public static String[] getArray(String data) {
        String clearData = data.replace("[", "").replace("]", "").
        replace("{", "").replace("\"", "");
        String[] arrData = clearData.split("},");
        return arrData;
    }

    public static StringBuilder getResult(String[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            String[] dataSet = array[i].split(",");
            String surname = dataSet[0].split(":")[1];
            String mark = dataSet[1].split(":")[1];
            String subject = dataSet[2].split(":")[1].replace("}", "");
            StringBuilder line = new StringBuilder("Студент ").
            append(surname).append(" получил ").append(mark).
            append(" по предмету ").append(subject);
            result.append(line + "\n");
            }
        return result;
        }
    }
