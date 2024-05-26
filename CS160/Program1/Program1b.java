/**
 *  Program 1b
 *  The program takes two strings as input and checks if one is a substring of the other. If they are equal, it prints "Both phrases match".
 *  If one is a substring of the other, it prints the substring and the string it is found in. If neither is a substring of the other, it prints "No matches". 
 *  CS160-1001
 *  5/26/24
 *  @author  Jacob Archer
  */

  import java.util.Scanner;

  public class Program1b {
      public static void main(String[] args) {
          Scanner scnr = new Scanner(System.in);
          String phrase1 = scnr.nextLine();
          String phrase2 = scnr.nextLine();
  
          if (phrase1.equals(phrase2)) {
              System.out.println("Both phrases match");
          } else if (phrase1.indexOf(phrase2) != -1) {
              System.out.println(phrase2 + " is found within " + phrase1);
          } else if (phrase2.indexOf(phrase1) != -1) {
              System.out.println(phrase1 + " is found within " + phrase2);
          } else {
              System.out.println("No matches");
          }
      }
  }