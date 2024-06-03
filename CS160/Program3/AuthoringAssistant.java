/**
 *  Program 3b
 *  This program is designed to assist authors in editing their documents.
 *  CS160-01
 *  6/2/2024
 *  @author  Jacob Archer
  */

  import java.util.Scanner;

  public class AuthoringAssistant {
     
     protected String usrStr;
  
      public void setUsrInput(String s) {
          this.usrStr = s;
      }
     
      public int getNumOfNonWSCharacters() {
        int count = 0;
        
        for (int i = 0; i < usrStr.length(); ++i) {
           if (!Character.isWhitespace(usrStr.charAt(i))) {
              ++count;
           }
        }
        
        return count;
     }
  
     public int getNumOfWords() {
        int count = 0;
        
        for (int i = 1; i < usrStr.length(); ++i) {
           if (Character.isWhitespace(usrStr.charAt(i)) && !Character.isWhitespace(usrStr.charAt(i - 1))) {
              ++count;
           }
        }
        
        if (!Character.isWhitespace(usrStr.charAt(usrStr.length() - 1))) {
           ++count;
        }
        
        return count;
     }
  
     public int findText(final String toFind) {
        int count = 0;
        int where = 0;
        
        do {
           where = usrStr.indexOf(toFind, where);
           
           if (where != -1) {
              count++;
              where++;
           }
        } while (where != -1);
        
        return count;
     }
     
     public String replaceExclamation() {
        return usrStr.replace('!', '.');
     }
     
     public String shortenSpace() {
        while (usrStr.contains("  ")) {
           usrStr = usrStr.replace("  ", " ");
        }
        
        return usrStr;
     }
     
     public char printMenu(Scanner scnr) {
        char menuOp;
        
        System.out.println("\nMENU");
        System.out.println("c - Number of non-whitespace characters");
        System.out.println("w - Number of words");
        System.out.println("f - Find text");
        System.out.println("r - Replace all !'s");
        System.out.println("s - Shorten spaces");
        System.out.println("i - Indent");
        System.out.println("x = Find and replace words");
        System.out.println("q - Quit\n");
        
        menuOp = ' ';
        
        while (menuOp != 'c' && menuOp != 'w' && menuOp != 'f' &&
               menuOp != 'r' && menuOp != 's' && menuOp != 'i' && 
               menuOp != 'x' && menuOp != 'q') {
           System.out.println("Choose an option:");
           menuOp = scnr.nextLine().charAt(0);
        }
        
        return menuOp;
     }
  }
  