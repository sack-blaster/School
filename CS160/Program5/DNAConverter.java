/**
 *  Program 5b
 *  This program converts DNA to RNA and RNA to Protein.
 *  CS160-01
 *  6/9/2024
 *  @author  Jacob Archer
  */
 
//import necessary libraries
import java.util.*;
import java.io.*;

public class DNAConverter {
    public static void main(String[] args) {
        DNAtoRNA("DNA.txt", "RNA.txt");
        RNAtoProtein("RNA.txt", "Protein.txt", "RNAtoProtein.txt");
    }

    public static void DNAtoRNA(String DNAFile, String RNAFile) {
        try {
            Scanner input = new Scanner(new File(DNAFile));
            PrintWriter output = new PrintWriter(RNAFile);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == 'A') {
                        output.print("U");
                    } else if (c == 'T') {
                        output.print("A");
                    } else if (c == 'C') {
                        output.print("G");
                    } else if (c == 'G') {
                        output.print("C");
                    } else {
                        throw new NoSuchElementException("Not a DNA character");
                    }
                }
                output.println();
            }
            input.close();
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void RNAtoProtein(String RNAFile, String ProteinFile, String RNAtoProteinTable) {
        try {
            Scanner input = new Scanner(new File(RNAFile));
            PrintWriter output = new PrintWriter(ProteinFile);
            Scanner table = new Scanner(new File(RNAtoProteinTable));
            Map<String, String> map = new HashMap<>();
            while (table.hasNextLine()) {
                String line = table.nextLine();
                String[] parts = line.split(" ");
                map.put(parts[0], parts[1]);
            }
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.length() % 3 != 0) {
                    throw new RuntimeException("Invalid RNA length");
                }
                for (int i = 0; i < line.length(); i += 3) {
                    String codon = line.substring(i, i + 3);
                    output.print(map.get(codon));
                }
                output.println();
            }
            input.close();
            output.close();
            table.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public String getId() {
        return "Program 5b, Jacob Archer";
    }
   
}