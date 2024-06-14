/**
 *  Program 5a
 *  This program converts DNA to RNA and RNA to Protein.
 *  CS160-01
 *  6/9/2024
 *  @author  Jacob Archer
  */
import java.io.*;
import java.util.Scanner;

public class WriteCSV {
    public static void main(String[] args) {
        String inputFilename = "coords.txt";
        String outputFilename = changeFileExtToCsv(inputFilename);

        Scanner input = openInput(inputFilename);
        PrintWriter output = openOutput(outputFilename);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            line = line.replace(" ", ",");
            output.println(line);
        }


        input.close();
        output.close();
    }

    public static String changeFileExtToCsv(String filename) {
        return filename.substring(0, filename.lastIndexOf('.')) + ".csv";
    }


    public static Scanner openInput(String filename) {
        Scanner in = null;
        try {
            File infile = new File(filename);
            in = new Scanner(infile);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println(filename + " could not be found");
            System.exit(0);
        }
        return in;
    }

    /**
     * Open output for writing
     *
     * @param filename
     * @return
     */
    public static PrintWriter openOutput(String filename) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Error opening " + filename + " for writing.");
            System.exit(0);
        }
        return out;
    }


    public String getID() {
        return "Program 4a, Jacob Archer";
      }
}
