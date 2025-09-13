/**Robert Yantin Jr.
 * CEN 3024 - Software Development I
 * September 15, 2025
 * Main.java
 * This class is where the program actually starts running, and it represents the overall
 * objective of this project.  By creating this Library Management System (LMS), the librarians can
 * manage a list of patrons.
 * This program gives the librarians a way to add new patrons, remove patrons, view all patrons, or load patrons
 * from a file in a way that's organized and easy to use.  By starting the ConsoleUI loop in Main, the program
 * creates a menu driven system where librarians can interact with the LMS without having to touch the code.
 */

package lms;

//Launcher class where it starts the UI
public class Main {
    public static void main(String[] args) {
        PatronManager manager = new PatronManager();
        FileImporter importer = new FileImporter();
        ConsoleUI ui = new ConsoleUI(manager, importer);

        //Keeps the program running until user exits
        ui.run();
    }
}