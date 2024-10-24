package main.model;


import java.util.Date;
import java.util.PriorityQueue;

public abstract class Medicine {
    private int din; 
    private String name; 
    private String ingredient; 
    private double strength; 
    private String formula; 
    private String manufacturer; 
    private String category; 
    PriorityQueue<ExpirationInfo> exps;
    private double price; 
    private double markup; 


    // Constructor
    public Medicine(int din, String name, String ingredient, double strength, String formula, 
                    String manufacturer, String category, ExpirationInfo exp,
                    double price, double markup) {
        this.din = din;
        this.name = name;
        this.ingredient = ingredient;
        this.strength = strength;
        this.formula = formula;
        this.manufacturer = manufacturer;
        this.category = category;
        this.price = price;
        this.markup = markup;

        this.exps = new PriorityQueue<>();
        this.exps.add(exp);    
    }

    // Getters and Setters
    public int getDin() {
        return din;
    }

    public String getName() {
        return name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public double getStrength() {
        return strength;
    }

    public String getFormula() {
        return formula;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public PriorityQueue<ExpirationInfo> getExpirationInfos() {
        return exps;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public double getTotalQuantity() {
        double total = 0;

        for(ExpirationInfo exp : exps) {
            total = total + exp.getQuantity();
        }

        return total;
    }

    public double getQuantityByLot (String lot) {
        double quantity = 0;

        for(ExpirationInfo exp : exps) {
            if (exp.getLot().equals(lot)) {
                quantity += exp.getQuantity();
            }
        }

        return quantity;
    }

    public double getQuantityByExp (Date expiDate) {
        double quantity = 0;

        for(ExpirationInfo exp : exps) {
            if (exp.getExpDate().equals(expiDate)) {
                quantity += exp.getQuantity();
            }
        }

        return quantity;
    }

    public Date getCurrentExp() {
        return exps.peek().getExpDate();
    }

    public String getCurrentLot() {
        return exps.peek().getLot();
    }
}
