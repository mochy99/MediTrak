package main.model;

import java.util.Date;

public interface Trade {
    /**
     * REQUIRES: quantity is greater than 0
     * MODIFIES: this
     * EFFECTS: Adds the quantity for the specified lot and expiration date.
     *          If the lot already exists, updates the quantity for the existing expiration date.
     *          If the lot doesn't exist, adds a new ExpirationInfo entry.
     *          Sorts the expiration information by expiration date and lot number after the addition.
     */
    void purchase(double quantity, String lot, Date expiration);

    // REQUIRES: quantity must be less than or equal to available quantity
    // MODIFIES: this
    // EFFECTS: Processes the dispensing of a specified quantity for a given lot.
    void dispense(double quantity, String lot);
}
