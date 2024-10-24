package main.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {
    private HashMap<Integer, Drug> drugs;
    
    // Constructor
    public Inventory() {
        drugs = new HashMap<>();
    }

    // MODIFIES this
    // EFFECTS add drug into the inventory
    public void add(Drug drug) {
        drugs.put(drug.getDin(), drug);
    }

    public HashMap<Integer, Drug> getDrugs() {
        return this.drugs;
    }
   
    // EFFECTS show a list of all medications in the inventory
    public List<Object> View() {
        List<Object> list = new ArrayList<>();

        drugs.forEach((din , drug) -> {
            List<Object> curDrug = new ArrayList<>();

            curDrug.add(din);
            curDrug.add(drug.getName());
            curDrug.add(drug.getIngredient());
            curDrug.add(drug.getStrength());
            curDrug.add(drug.getManufacturer());
            curDrug.add(drug.getTotalQuantity());

            list.add(curDrug);
        } );

        return list;
    }

    // EFFECTS: Displays a list of all medications in the inventory,
    //          including details of expiration date and lot number 
    //          for each medication.
    public List<Object> DetailedView() {
        List<Object> list = new ArrayList<>();

        return list;
    }

    // EFFECTS: Display drug search by din
    public Drug SearchByDin(int din) {
        if (drugs.containsKey(din)) {
            return drugs.get(din);
        }
        return null;
    }

    // EFFECTS: Display drug search by din
    public Drug SearchByName(String brandName) {
        for (Drug drug : this.drugs.values()) { 
            if (drug.getName().equals(brandName)) {
                return drug; 
            }
        }
        return null; 
    }
    


    // EFFECTS: Display drug search by din
    public Drug SearchByIngredient(String ingredient) {
        for (Drug drug : this.drugs.values()) { 
            if (drug.getIngredient().equals(ingredient)) {
                return drug; 
            }
        }
        return null;
    }



}
