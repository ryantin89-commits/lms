//Robert Yantin Jr.
//CEN 3024 - Software Development I
//September 15, 2025
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