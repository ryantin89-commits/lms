/**Robert Yantin Jr.
 * CEN 3024 - Software Development I
 * September 15, 2025
 * PatronManager.java
 * This class acts as the actual rules for managing the patrons like adding, removing, checking if
 * an ID is valid, making sure fines are in range, and stopping duplicate records.
 * Controls the list of patrons that the system works with.
 */

package lms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatronManager {
    private final List<Patron> patrons = new ArrayList<>();

    //Adds one patron if it's valid and not a duplicate
    public boolean addPatron(int id, String name, String address, float fineAmount) {
        //Checks for validation ID, Fine Amount, Unique IDs
        if (!isValidID(id)) return false; //ID must be exactly 7 digits
        if (!isValidFineAmount(fineAmount)) {
            return false; //fine must be $0 - $250
        }
        if (getPatronById(id) != null) return false; //unique IDs only

        patrons.add(new Patron(id, name, address, fineAmount));
        return true;
    }

    //Remove by ID - returns true if something was actually removed
    public boolean removePatron(int id) {
        Iterator<Patron> iterator = patrons.iterator();
        while (iterator.hasNext()) {
            Patron p = iterator.next();
            if (p.getId() == id) {
                iterator.remove(); //safe removal during iteration
                return true;
            }
        }
        return false;
    }

    //Find one patron or return null if not found
    public Patron getPatronById(int id) {
        for (Patron p : patrons) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    //Give back a copy so users can't accidentally mess with the list
    public List<Patron> listPatrons() {
        return new ArrayList<>(patrons);
    }

    //Bulk adds from file.  Only valid plus non duplicate patrons are added
    public int importFromFile(String filePath, FileImporter importer) {
        List<Patron> fromFile = importer.importPatrons(filePath);
        int added = 0;

        for (Patron p : fromFile) {
            //Rechecking rules here just in case the file had weird data coming in
            if (isValidID(p.getId()) && isValidFineAmount(p.getFineAmount())
                    && getPatronById(p.getId()) == null) {
                patrons.add(p);
                added++;
            }
        }
        return added; //Tells UI how many were actually imported
    }

    //These are validation helpers (keeping them together so they are easier to change, if needed)
    private boolean isValidID(int id) {
        //7 digits from 1000000 to 9999999
        return id >= 1000000 && id <= 9999999;
    }

    private boolean isValidFineAmount(float fineAmount) {
        //Range for the fine amount
        return fineAmount >= 0.0f && fineAmount <= 250.0f;

    }
}