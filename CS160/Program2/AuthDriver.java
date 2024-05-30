/**
 *  Program 2
 *  This program is designed to assist authors in editing their documents.
 *  CS160-01
 *  5/30/2024
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
        AuthoringAssistant auth = new AuthoringAssistant();
        auth.setUsrInput(inputString);
    
        menuChoice = ' ';
        // Execute menu command
        while (menuChoice != 'q') {
            menuChoice = auth.printMenu(scnr);
       
            if (menuChoice == 'c') {
            System.out.println("Number of non-whitespace characters: " + auth.getNumOfNonWSCharacters());
            // menuChoice = ' ';
            }
       
            else if (menuChoice == 'w') {
            System.out.println("Number of words: " + auth.getNumOfWords());
            // menuChoice = ' ';
            }
       
            else if (menuChoice == 'f') {
            System.out.println( "Enter a word or phrase to be found:");
            toFind = scnr.nextLine();
            System.out.println("\"" + toFind + "\"" + " instances: " + auth.findText(toFind));
            // menuChoice = ' ';
            }
    
            else if (menuChoice == 'r') {
            inputString = auth.replaceExclamation();
            System.out.println("Edited text: " + inputString);
            // menuChoice = ' ';
            }
    
            else if (menuChoice == 's') {
            inputString = auth.shortenSpace();
            System.out.println("Edited text: " + inputString);
            // menuChoice = ' ';
            }
        }   
    }
}