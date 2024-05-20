import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class encryptIntro {
    public static void main(String[] args) {
        String intro = "";
        try {
            File introtxt = new File("intro.txt");
            Scanner myReader = new Scanner(introtxt);
            while (myReader.hasNextLine()) {
                intro = intro + myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .,?!1234567890";
        String cipher = "";
        int introLength = intro.length();

        for (int i = 0; i < introLength; i++) {
            char letter = intro.charAt(i);
            int position = alphabet.indexOf(letter);
            if (position == 0) {
                cipher = cipher + alphabet.charAt(25);
            } else if (position == 26) {
                cipher = cipher + alphabet.charAt(51);
            } else if (position == 52) {
                cipher = cipher + alphabet.charAt(52);
            } else if (position == 53) {
                cipher = cipher + alphabet.charAt(53);
            } else {
                int newPosition = (position - 1);
                cipher = cipher + alphabet.charAt(newPosition);
            }
        }
        
        System.out.println(cipher);
    }
}
