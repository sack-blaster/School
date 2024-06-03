/**
 *  Program 3b
 *  This program is designed to assist authors in editing their documents.
 *  CS160-01
 *  6/2/2024
 *  @author  Jacob Archer
  */

  import java.util.Scanner;

  public class AuthDriver {
      public static void main(String[] args) {
          Scanner scnr = new Scanner(System.in);
          String inputString;
          char menuChoice;
          String toFind;
  
          // Get string from user
          System.out.println("Enter a sample text:");
          inputString = scnr.nextLine();
          System.out.println("\nYou entered: " + inputString);
  
          AuthoringAssistantPlus auth = new AuthoringAssistantPlus();
          auth.setUsrInput(inputString);
  
          menuChoice = ' ';
          // Execute menu command
          while (menuChoice != 'q') {
              menuChoice = auth.printMenu(scnr);
  
              switch (menuChoice) {
                  case 'c':
                      System.out.println("Number of non-whitespace characters: " + auth.getNumOfNonWSCharacters());
                      break;
                  case 'w':
                      System.out.println("Number of words: " + auth.getNumOfWords());
                      break;
                  case 'f':
                      System.out.println("Enter a word or phrase to be found:");
                      toFind = scnr.nextLine();
                      System.out.println("\"" + toFind + "\"" + " instances: " + auth.findText(toFind));
                      break;
                  case 'r':
                      inputString = auth.replaceExclamation();
                      System.out.println("Edited text: " + inputString);
                      break;
                  case 's':
                      inputString = auth.shortenSpace();
                      System.out.println("Edited text: " + inputString);
                      break;
                  case 'i':
                      System.out.println("Enter the number of spaces to indent:");
                      int spaces = Integer.parseInt(scnr.nextLine());
                      inputString = auth.indent(spaces);
                      System.out.println("Edited text: " + inputString);
                      break;
                  case 'x':
                      System.out.println("Enter a word to be found:");
                      String wordToFind = scnr.nextLine();
                      System.out.println("Enter a word to replace:");
                      String replaceWith = scnr.nextLine();
                      inputString = auth.findAndReplaceWith(wordToFind, replaceWith);
                      System.out.println("Edited text: " + inputString);
                      break;
                  case 'q':
                      break;
                  default:
                      System.out.println("Invalid option. Please try again.");
              }
          }
          scnr.close();
      }
  }
  