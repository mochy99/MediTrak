package main.model;

import java.util.Date;

public class ExpirationInfo  implements Comparable<ExpirationInfo>{
    private Date expDate; 
    private String lot;
    private double quantity; 

    public ExpirationInfo(Date expDate, String lot, double quantity) {
        this.expDate = expDate;
        this.lot = lot;
        this.quantity = quantity;
    }

    // Getters
    public Date getExpDate() {
        return expDate;
    }

   
    public String getLot() {
        return lot;
    } 

    public double getQuantity() {
        return quantity;
    }

    public void purchase(double amt) {
        this.quantity += amt;
    }

    public void dispense(double amt) {
        this.quantity -= amt;
    }

    @Override
    public int compareTo(ExpirationInfo other) {
        // First compare by expiration date
        int dateComparison = this.expDate.compareTo(other.getExpDate());
        
        // If expiration dates are the same, compare by lot
        if (dateComparison == 0) {
            return this.lot.compareTo(other.getLot());
        }
        
        return dateComparison;
    }
    
}
