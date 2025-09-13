# Library Management System (LMS)

## Overview
This project is a simple console app I built for my Software Development
I class.  The whole point of it is to manage library patrons in an easy
way.  It's not a full blow library system, but it covers the basics like
adding patrons, removing them, showing who's in the system, and even loading
a list of patrons from a text file.

## Features
- Add patrons manually with a 7 digit ID, name, address, and fine amount with ranges of $0 to $250.
- Remove patrons from the system using their ID.
- Show all patrons that currently live in the system.
- Import multiple patrons from a file if you don't want to type them one at a time.
- Basic validations like making sure IDs are 7 digits, fines are between $0 and 250, and no duplicates.

## Classes
- **Main.java**: Entry point of the program.  Starts the UI.
- **ConsoleUI.java**: Handles the menu system and user interaction.
- **PatronManager.java**: Manages the list of patrons and enforces validation rules.
- **Patron.java**: Represents one patron object with ID, name, address, and fine amount.
- **FileImporter.java**: Reads patrons from a file and parses them into the system.

## Example Input File Format
Each line is one patron, separated by dashes:
1111111-First Last-111 1st St. Orlando, Fl 32323-29.99
1234567-Jose Ortiz-222 2nd St. Kissimmee, FL 34744-5.37
9876543-Jane Smith-333 3rd St. Daytona, FL 36636-0

## How to Run
1. Clone this repo.
2. Open the project in IntelliJ (this is the software that I used).
3. Run Main.java.
4. Use the menu options in the console to test it out.

## Author
Robert Yantin Jr.
CEN 3024 - Software Development I