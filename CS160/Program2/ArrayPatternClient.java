/**
 *  Program 2c
 *  This program creates a pattern of numbers and prints them in a grid.
 *  CS160-01
 *  5/30/2024
 *  @author  Jacob Archer
  */

import java.util.Scanner;

public class ArrayPatternClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();
        ArrayPattern arrayPattern = new ArrayPattern();

        if (scanner.hasNextInt()) {
            int numCols = scanner.nextInt();
            int[][] twoDArray = arrayPattern.createPattern(numRows, numCols);
            arrayPattern.print(twoDArray);
            arrayPattern.transpose(twoDArray);
        } else {
            int[] array = arrayPattern.createPattern(numRows);
            arrayPattern.print(array);
            arrayPattern.transpose(array);
        }
    }
}
