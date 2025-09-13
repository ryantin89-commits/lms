/**Robert Yantin Jr.
 * CEN 3024 - Software Development I
 * September 15, 2025
 * Patron.java
 * This class is the blueprint for a single library user.  It holds the basic info like the patron's ID,
 * name, address, and fine amount.  It doesn't do anything on its own, it just keeps all the data together
 * in one object so the other parts of the program can use it.
 */

package lms;

public class Patron {
    private int id;
    private String name;
    private String address;
    private float fineAmount;

    //Constructor
    public Patron(int id, String name, String address, float fineAmount) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fineAmount = fineAmount;
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(float fineAmount) {
        this.fineAmount = fineAmount;
    }

    //This shows the list view nice and neat
    @Override
    public String toString() {
        return String.format("ID: %07d | Name: %s | Address: %s | Fine Amount: $%.2f", id, name, address, fineAmount);
    }
}