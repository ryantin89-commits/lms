/**Robert Yantin Jr.
 * CEN 3024 - Software Development I
 * September 15, 2025
 * ConsoleUI.java
 * This class is the "front desk" of the program.  It's the part that the user actually interacts
 * with, and it shows the menu, taking in whatever the user types, and then calling the right methods
 * in PatronManager.java or FileImporter.java.
 */

package lms;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final PatronManager manager;
    private final FileImporter importer;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(PatronManager manager, FileImporter importer) {
        this.manager = manager;
        this.importer = importer;
    }


    //Prints the menu on the screen
    public void displayMenu() {
        System.out.println("\nWelcome to the Library Management System");
        System.out.println("1. Add Patron");
        System.out.println("2. Remove Patron");
        System.out.println("3. List Patrons");
        System.out.println("4. Import Patrons from File");
        System.out.println("0. Exit Application");
        System.out.println("Choose an option: ");
    }

    //Below is the main application loop - continues until user chooses to exit
    public void run() {
        boolean keepRunning = true;

        while (keepRunning) {
            try {
                displayMenu();
                String userInput = scanner.nextLine().trim();

                //If user types 0, quit, or exit, the loops ends
                if (userInput.equals("0") || userInput.equalsIgnoreCase("quit")
                        || userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Thanks for using the LMS application!");
                    keepRunning = false;
                } else {
                    //Sends user choice to another method so the loops stays clean
                    handleUserChoice(userInput);
                }

            } catch (NumberFormatException nfe) {
                //Usually happens if user types letters instead of numbers
                System.out.println("Invalid ID Number.  Please try again.");

            } catch (Exception e) {
                //In case something else weird happens, the app does not crash
                System.out.println("Something went wrong.  Please try again.");
            }
        }
    }

    //This is where the user makes the selection like "1", "2", "3" to be sent to the right function
    private void handleUserChoice(String choice) {
        switch (choice) {
            case "1":
                handleAddPatron();
                break;
            case "2":
                handleRemovePatron();
                break;
            case "3":
                handleListPatrons();
                break;
            case "4":
                handleImportPatrons();
                break;
            default:
                System.out.println("Invalid choice. Please try again");
        }
    }

    //Asks user for information to add patron to the system
    private void handleAddPatron() {
        try {
            System.out.print("Enter 7-Digit ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Address: ");
            String address = scanner.nextLine().trim();

            System.out.print("Enter Fine Amount ($0 to $250): ");
            float fineAmount = Float.parseFloat(scanner.nextLine().trim());

            if (manager.addPatron(id, name, address, fineAmount)) {
                System.out.println("\nPatron added successfully!");

                //After adding, show the full list of patrons so the user sees the update
                System.out.println("\nHere is the full list of patrons:");
                for (Patron p : manager.listPatrons()) {
                    System.out.println(p);
                }
            } else {
                //If adding fails
                System.out.println("Could not add patron (Check ID/Fine Amount/Duplicate).");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Patron not added.");
        }
    }

    //Asks user for ID and try to remove that Patron
    private void handleRemovePatron() {
        try {
            System.out.print("Enter 7-Digit ID to remove: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            if (manager.removePatron(id)) {
                System.out.println("\nPatron removed successfully!");

                //After removing, show the full list of patrons so the user sees the updated list
                System.out.println("\nHere is the full list of patrons:");
                for (Patron p : manager.listPatrons()) {
                    System.out.println(p);
                }
            } else {
                //If removing fails
                System.out.println("No patron found with that ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Patron not removed.");
        }
    }

    //Prints out all patrons currently stored
    private void handleListPatrons() {
        List<Patron> list = manager.listPatrons();
        if (list.isEmpty()) {
            System.out.println("No Patrons Found.");
        } else {
            System.out.println("\nPatron List");
            for (Patron p : list) {
                System.out.println(p); //prints using Patron.toString()
            }
        }
    }

    //Asks user for a file path, import patrons from that file
    private void handleImportPatrons() {
        System.out.print("Enter file path: ");
        String path = scanner.nextLine().trim();
        int added = manager.importFromFile(path, importer);
        System.out.println("Imported " + added + " patrons from file (valid records only).");
        System.out.println("Here are the newly added patrons from file in the system:");
        //Prints the list of Patrons after import
        for (Patron p : manager.listPatrons()) {
            System.out.println(p);
        }
    }
}