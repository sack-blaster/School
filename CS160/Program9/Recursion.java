/**
 *  Program 9
 *  This program is a recursion class
 *  CS160-1001
 *  6/23/24
 *  @author  Jacob Archer
  */

import java.util.ArrayList;
import java.util.Arrays;

public class Recursion {

    private ArrayList<Integer> list;

    public Recursion(int[] array) {
        list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
    }

    public ArrayList<Integer> reverseList(ArrayList<Integer> input) {
        if (input.size() <= 1) {
            return new ArrayList<>(input);
        }
        ArrayList<Integer> result = new ArrayList<>(input.subList(1, input.size()));
        result = reverseList(result);
        result.add(input.get(0));
        return result;
    }

    public ArrayList<Integer> reverseList() {
        return reverseList(list);
    }

    public ArrayList<Integer> toOddList(ArrayList<Integer> input) {
        return toOddListHelper(input, 0);
    }

    private ArrayList<Integer> toOddListHelper(ArrayList<Integer> input, int index) {
        ArrayList<Integer> result = new ArrayList<>();
        if (index >= input.size()) {
            return result;
        }
        if (index % 2 == 1) {
            result.add(input.get(index));
        }
        result.addAll(toOddListHelper(input, index + 1));
        return result;
    }

    public ArrayList<Integer> toOddList() {
        return toOddList(list);
    }

    public ArrayList<Integer> toEvenRevList(ArrayList<Integer> input) {
        ArrayList<Integer> evenList = toEvenListHelper(input, 0);
        return reverseList(evenList);
    }

    private ArrayList<Integer> toEvenListHelper(ArrayList<Integer> input, int index) {
        ArrayList<Integer> result = new ArrayList<>();
        if (index >= input.size()) {
            return result;
        }
        if (index % 2 == 0) {
            result.add(input.get(index));
        }
        result.addAll(toEvenListHelper(input, index + 1));
        return result;
    }

    public ArrayList<Integer> toEvenRevList() {
        return toEvenRevList(list);
    }

    public int retPenultimate(ArrayList<Integer> input) {
        if (input == null || input.size() == 0) {
            return -1;
        }
        return retPenultimateHelper(input, input.size());
    }

    private int retPenultimateHelper(ArrayList<Integer> input, int size) {
        if (size == 1) {
            return input.get(0);
        }
        if (size == 2) {
            return input.get(1);
        }
        return retPenultimateHelper(input, size - 1);
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10};
        Recursion recursion = new Recursion(array);

        System.out.println("Original: " + recursion.getList());
        System.out.println("reverseList(): " + recursion.reverseList());
        System.out.println("toOddList(): " + recursion.toOddList());
        System.out.println("toEvenRevList(): " + recursion.toEvenRevList());
        System.out.println("retPenultimate(): " + recursion.retPenultimate(recursion.getList()));
    }
}
