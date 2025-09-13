//Robert Yantin Jr.
//CEN 3024 - Software Development I
//September 15, 2025
package lms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
 * This class reads patrons from a text file.
 * Expected line format: id-name-address-fineamount
 * Example: 1234567-Jay Joe-123 Good St. Orlando, FL 32822-12.50
 *
 * This class only parses the file into Patron objects.
 * Validation (7 digit ID, fine range, duplicates) is rechecked in PatronManager.
 */
public class FileImporter {
    public List<Patron> importPatrons(String filePath) {
        List<Patron> result = new ArrayList<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            int lineNumber = 0;

            //Reads the file line by line
            while ((line = br.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                if (line.isEmpty()) continue; //ignore blank lines

                //Simple split on '-'
                String[] parts = line.split("-", -1); //keep empty fields if any
                if (parts.length != 4) {
                    System.out.println("Skipping line " + lineNumber + " (wrong format)");
                    continue;
                }

                try {
                    //Try to convert fields into a Patron
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String address = parts[2].trim();
                    float fineAmount = Float.parseFloat(parts[3].trim());

                    result.add(new Patron(id, name, address, fineAmount));
                } catch (NumberFormatException nfe) {
                    //If ID or fine aren't numbers, skip this line
                    System.out.println("Skipping line" + lineNumber + " (bad number)");
                }
            }
        } catch (Exception e) {
            //File not found, permissions, etc.
            System.out.println("Could not read file: " + e.getMessage());
        } finally {
            //Make sure the file handle closes even if something went wrong
            try {
                if (br != null) br.close();
            } catch (Exception ignore) {
            }
        }

        return result;
    }
}