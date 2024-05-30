/**
 *  Program 2c
 *  This program creates a pattern of numbers and prints them in a grid.
 *  CS160-01
 *  5/30/2024
 *  @author  Jacob Archer
  */

  public class ArrayPattern {
    
    public String getId() {
        return "Program 2c, Jacob Archer";
    }

    public int[] createPattern(int numCols) {
        int[] array = new int[numCols];
        for (int i = 0; i < numCols; i++) {
            array[i] = (i + 1) * numCols;
            if (i >= numCols / 2) {
                array[i] = array[numCols - i - 1];
            }
        }
        return array;
    }

    public int[][] createPattern(int numRows, int numCols) {
        int[][] array = new int[numRows][numCols];
        int count = 0;
        if (numRows == 1) {
            return new int[][] { createPattern(numCols) };
        }

        else {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    array[i][j] = count++;
                }
            }
            return array;
        }
    }

    public void print(int[] someArray) {
        for (int i = 0; i < someArray.length; i++) {
            System.out.format("%-4d", someArray[i]);
        }
        System.out.println();
    }

    public void print(int[][] someOtherArray) {
        for (int i = 0; i < someOtherArray.length; i++) {
            for (int j = 0; j < someOtherArray[i].length; j++) {
                System.out.format("%-4d", someOtherArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void transpose(int[] someArray) {
        for (int i = 0; i < someArray.length; i++) {
            System.out.format("%-4d", someArray[i]);
            System.out.println();
        }
        System.out.println();
    }

    public void transpose(int[][] someOtherArray) {
        for (int i = 0; i < someOtherArray[0].length; i++) {
            for (int j = 0; j < someOtherArray.length; j++) {
                System.out.format("%-4d", someOtherArray[j][i]);
            }
            System.out.println();
        }
        System.out.println();
    }
}