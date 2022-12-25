package HW_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
*/
public class Ex004 {
    public static void main(String[] args) {
        Ex004 task = new Ex004();
        ArrayList<ArrayList<String>> board = new ArrayList<>(8);
        task.fillBoard(board);
        task.placeQueens(board);
        task.printBoard(board);
    }

    public void fillBoard(ArrayList<ArrayList<String>> board) {
        for (int i = 0; i < 8; i++) {
            ArrayList<String> line = new ArrayList<>(8);
            for (int j = 0; j < 8; j++) {
                line.add(".");
            }
            board.add(line);
        }
    }

    public void printBoard(ArrayList<ArrayList<String>> board) {
        for (int i = 0; i < 8; i++) {
            System.out.println(board.get(i));
        }
    }

    public void placeQueens(ArrayList<ArrayList<String>> board) {
        int row = 0;
        int box = 0;
        Stack<List<Integer>> queensPlaced = new Stack<>();
        while (queensPlaced.size() < 8) {
            if (checkBox(board, row, box)) {
                ArrayList<String> line = board.get(row);
                line.set(box, "Q");
                board.set(row, line);
                queensPlaced.push(Arrays.asList(row, box));
            } else {
                List<Integer> newBox = getNewBox(board, queensPlaced, row, box);
                row = newBox.get(0);
                box = newBox.get(1);
            }
        }
    }

    public List<Integer> getNewBox(ArrayList<ArrayList<String>> board, Stack<List<Integer>> queensPlaced, Integer row, Integer box) {
        if (box < 7) {
            box = box + 1;
        } else {
            if (row < 7) {
                row = row + 1;
                box = 0;
            } else {
                List<Integer> prevQueenPlace = queensPlaced.pop();
                row = prevQueenPlace.get(0);
                box = prevQueenPlace.get(1);
                ArrayList<String> line = board.get(row);
                line.set(box, ".");
                board.set(row, line);
                List<Integer> newBox = getNewBox(board, queensPlaced, row, box);
                row = newBox.get(0);
                box = newBox.get(1);
            }
        }
        return Arrays.asList(row, box);
    }

    public boolean checkBox(ArrayList<ArrayList<String>> board, int row, int box) {
        ArrayList<String> line = board.get(row);
        for (int j = 0; j < 8; j++) {
            ArrayList<String> tempLine = board.get(j);
            if (line.get(j).equals("Q") || tempLine.get(box).equals("Q")) {
                return false;
            };
        }

        for (int i = 0; i < 8; i++) {
            if (row + i < 8) {
                ArrayList<String> linePlus = board.get(row + i);
                if (box + i < 8) {
                    if (linePlus.get(box + i).equals("Q")) {
                        return false;
                    }

                }
                if (box - i >= 0) {
                    if (linePlus.get(box - i).equals("Q")) {
                        return false;
                    }
                }
            }

            if (row - i >= 0) {
                ArrayList<String> lineMinus = board.get(row - i);
                if (box + i < 8) {
                    if (lineMinus.get(box + i).equals("Q")) {
                        return false;
                    }

                }
                if (box - i >= 0) {
                    if (lineMinus.get(box - i).equals("Q")) {
                        return false;
                    }
                }
            }

        }
        return true;
    }
}
