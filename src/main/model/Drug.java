package main.model;

import java.util.Date;


public class Drug extends Medicine implements Trade {

    // Constructor for Drug
    public Drug(int din, String name, String ingredient, double strength, String formula, String manufacturer,
            String category, ExpirationInfo exp, double price, double markup) {
        super(din, name, ingredient, strength, formula, manufacturer, category, exp, price, markup);
    }

    
    @Override
    public void purchase(double quantity, String lot, Date expiration) {
        boolean isExisting = false;

        // If the lot and expiration exist, update quantity
        for (ExpirationInfo exp : exps) {
            if (exp.getExpDate().equals(expiration) && exp.getLot().equals(lot)) {
                isExisting = true;
                exp.purchase(quantity);
                break;
            }
        }

        // If the lot and expiration do not exist, add a new ExpirationInfo and sort it by exp and then lot
        if (!isExisting) {
            ExpirationInfo newExp = new ExpirationInfo(expiration, lot, quantity);
            this.exps.add(newExp);
        }


    }

    @Override
    public void dispense(double quantity, String lot) {
        
    }
}


