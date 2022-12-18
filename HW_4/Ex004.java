package HW_4;

import java.lang.reflect.Array;
import java.util.*;

/*
Реализовать алгоритм перевода из инфиксной записи
в постфиксную для арифметического выражения.
http://primat.org/news/obratnaja_polskaja_zapis/2016-04-09-1181
Вычислить запись если это возможно.
(Объяснение подобной задачи есть в лекции)
*/
public class Ex004 {
    public static void main(String[] args) {
        String infixExpr = "(1 + 2) * (3 + 4 + 5) / (9 - 10)"; // работает только с выражениями такого вида
        String[] exprArr = exprToArray(infixExpr);
        Stack<String> operatorStack = new Stack<>();
        LinkedList<String> postfixList = new LinkedList<>();
        parseExprList(exprArr, operatorStack, postfixList);
        String postfixExpr = String.join(" ", postfixList);
        System.out.println("Инфиксная запись: " + infixExpr);
        System.out.println("Постфиксная запись: " + postfixExpr);
        System.out.println("Вычисление: " + calculate(postfixList));
    }

    public static String[] exprToArray(String infixExpr) {
        String updExpr = infixExpr.replace("(", "( ").replace(")", " )");
        return updExpr.split(" ");
    }

    public static void parseExprList(String[] exprArr, Stack<String> operatorStack,
                                     LinkedList<String> postfixList) {
        HashMap<String, Integer> operatorValue = new HashMap<String, Integer>();
        operatorValue.put("/", 3);
        operatorValue.put("*", 3);
        operatorValue.put("+", 2);
        operatorValue.put("-", 2);
        operatorValue.put("(", 1);
        for (String element : exprArr) {
            if (isNumeric(element)) {
                postfixList.addLast(element);
            } else if (element.equals("(")) {
                operatorStack.push(element);
            } else if (element.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    postfixList.addLast(operatorStack.pop());
                }
                operatorStack.pop();

            } else {
                while ((!operatorStack.isEmpty()) &&
                        (operatorValue.get(operatorStack.peek()) >= operatorValue.get(element))) {
                    postfixList.addLast(operatorStack.pop());
                }
                operatorStack.push(element);
            }
        }
        while (!operatorStack.isEmpty()) {
            postfixList.addLast(operatorStack.pop());
        }
    }

    public static boolean isNumeric(String line) {
        if (line == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(line);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String calculate(LinkedList <String> postfixList){
        Stack <Double> calculator = new Stack<Double>();
        for (String element: postfixList) {
            if (isNumeric(element)) {
                Double number = Double.parseDouble(element);
                calculator.push(number);
            } else {
                Double secondNumber = calculator.pop();
                Double firstNumber = calculator.pop();
                switch (element) {
                    case "+" -> calculator.push(firstNumber + secondNumber);
                    case "-" -> calculator.push(firstNumber - secondNumber);
                    case "*" -> calculator.push(firstNumber * secondNumber);
                    default -> {
                        if (secondNumber == 0) {
                            return "Попытка деления на ноль!";
                        } else {
                            calculator.push(firstNumber / secondNumber);
                        }
                    }
                    }
                }
            }
        return calculator.pop().toString();
    }
}
