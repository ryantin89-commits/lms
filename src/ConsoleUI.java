//Robert Yantin Jr.
//CEN 3024 - Software Development I
//September 15, 2025


import java.util.Scanner;

public class ConsoleUI {
    private PatronManager manager;
    private FileImporter importer;
    private Scanner scanner = new Scanner(system.in);

    public ConsoleUI(PatronManager manager, FileImporter importer) {
        this.manager = manager;
        this.importer = importer;
    }

    public void displayMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Patron");
        System.out.println("2. Remove Patron a new Book");
        System.out.println("3. Create a new User");
        System.out.println("0. Exit");
        System.out.println("Select an option");
        System.out.println("Choose an option: ");
    }
}
