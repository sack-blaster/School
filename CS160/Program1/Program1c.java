import java.util.Scanner;
import java.util.Arrays;

public class Program1c {
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int [] diceValues = new int[5];
      int highScore = 0;
       
      // Fill array with five values from input
      for(int i=0; i<diceValues.length; ++i) {
         diceValues[i] = scnr.nextInt();
      }
      
      // Place values in ascending order
      Arrays.sort(diceValues);
      
      // Find high score and output
      highScore = findHighScore(diceValues);
      System.out.println("High score: " + highScore);
   }

   // Find high score, Check across all methods
   public static int findHighScore(int dice[]) {
      int highScore = 0;
    for (int i = 1; i <= 6; i++) {
        int score = checkSingles(dice, i);
        if (score > highScore) {
            highScore = score;
        }
    }
      
      if (checkThreeOfKind(dice) > highScore) {
         highScore = checkThreeOfKind(dice);
      }
      if (checkFourOfKind(dice) > highScore) {
         highScore = checkFourOfKind(dice);
      }
      if (checkFiveOfKind(dice) > highScore) {
         highScore = checkFiveOfKind(dice);
      }
      if (checkFullHouse(dice) > highScore) {
         highScore = checkFullHouse(dice);
      }
      if (checkStraight(dice) > highScore) {
         highScore = checkStraight(dice);
      }
    return highScore;
   }
   
   // Add all occurences of goal value
   public static int checkSingles(int dice[], int goal) {
      int sum = 0;
    for (int i = 0; i < dice.length; i++) {
        if (dice[i] == goal) {
            sum += goal;
        }
    }
    return sum; 
   } 
   
   // Check for three of a kind (score = 30)    
   public static int checkThreeOfKind(int dice[]) {
      for (int i = 0; i < dice.length - 2; i++) {
          if (dice[i] == dice[i + 1] && dice[i] == dice[i + 2]) {
              return 30;
          }
      }
      return 0;
   }
   
   // Check for four of a kind (score = 40)    
   public static int checkFourOfKind(int dice[]) {
      for (int i = 0; i < dice.length - 3; i++) {
          if (dice[i] == dice[i + 1] && dice[i] == dice[i + 2] && dice[i] == dice[i + 3]) {
              return 40;
          }
      }
      return 0;
   }   
   
   // Check for five of a kind (score = 50)    
   public static int checkFiveOfKind(int dice[]) {
      for (int i = 0; i < dice.length - 4; i++) {
          if (dice[i] == dice[i + 1] && dice[i] == dice[i + 2] && dice[i] == dice[i + 3] && dice[i] == dice[i + 4]) {
              return 50;
          }
      }
      return 0;
   }        
   
   // Check for full house (score = 35)
   public static int checkFullHouse(int dice[]) {     
      if (dice[0] == dice[1] && dice[2] == dice[3] && dice[2] == dice[4]) {
          return 35;
      } else if (dice[0] == dice[1] && dice[0] == dice[2] && dice[3] == dice[4]) {
          return 35;
      } else {
          return 0;
      }
   } 
   
   // Check for straight (score = 45)    
   public static int checkStraight(int dice[]) {
      for (int i = 0; i < dice.length - 1; i++) {
          if (dice[i] != dice[i + 1] - 1) {
              return 0;
          }
      }
      return 45; 
   }   
}

