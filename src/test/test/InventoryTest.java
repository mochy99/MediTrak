package test.test;

import java.time.LocalDate;
import java.util.List;
import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.model.Drug;
import main.model.ExpirationInfo;
import main.model.Inventory;

public class InventoryTest {
    private Inventory inventory; 
    private String lotA, lotB, lotC, lotD, lotE;
    private Date expA, expB, expC, expD, expE;
    private Drug drugA, drugB, drugC, drugD, drugE;

    @BeforeEach
    public void runBefore() {
        inventory = new Inventory();

        lotA = "A20669";
        expA = Date.valueOf(LocalDate.of(2028, 8, 31));

        lotB = "B30582";
        expB = Date.valueOf(LocalDate.of(2025, 5, 15));

        lotC = "C40891";
        expC = Date.valueOf(LocalDate.of(2027, 3, 12));

        lotD = "D50934";
        expD = Date.valueOf(LocalDate.of(2026, 11, 20));

        lotE = "E60321";
        expE = Date.valueOf(LocalDate.of(2029, 2, 5));

        ExpirationInfo expirationInfA = new ExpirationInfo(expA, lotA, 30.0);
        ExpirationInfo expirationInfB = new ExpirationInfo(expB, lotB, 25.0);
        ExpirationInfo expirationInfC = new ExpirationInfo(expC, lotC, 50.0);
        ExpirationInfo expirationInfD = new ExpirationInfo(expD, lotD, 10.0);
        ExpirationInfo expirationInfE = new ExpirationInfo(expE, lotE, 20.0);

        drugA = new Drug(123, "Forxiga", "Dapaglifozin", 10, 
                         "tab", "AZ", "RXB", expirationInfA, 
                         109.75, 0.2);

        drugB = new Drug(124, "Jardiance", "Empagliflozin", 25, 
                         "tab", "Boehringer Ingelheim", "RXB", expirationInfB, 
                         115.00, 0.15);

        drugC = new Drug(125, "Ozempic", "Semaglutide", 1, 
                         "pen", "Novo Nordisk", "RXB", expirationInfC, 
                         150.50, 0.18);

        drugD = new Drug(126, "Trulicity", "Dulaglutide", 1.5, 
                         "pen", "Lilly", "RXB", expirationInfD, 
                         145.25, 0.22);

        drugE = new Drug(127, "Xarelto", "Rivaroxaban", 20, 
                         "tab", "Bayer", "RXB", expirationInfE, 
                         105.80, 0.2);
        
        // Add drugs to the inventory
        inventory.add(drugA);
        inventory.add(drugB);
        inventory.add(drugC);
        inventory.add(drugD);
        inventory.add(drugE);
    }

    @Test
    public void testAdd() {
        assertTrue(inventory.getDrugs().containsValue(drugA), "Inventory should contain Forxiga");
        assertTrue(inventory.getDrugs().containsValue(drugB), "Inventory should contain Jardiance");
        assertTrue(inventory.getDrugs().containsValue(drugC), "Inventory should contain Ozempic");
        assertTrue(inventory.getDrugs().containsValue(drugD), "Inventory should contain Trulicity");
        assertTrue(inventory.getDrugs().containsValue(drugE), "Inventory should contain Xarelto");

        assertEquals(5, inventory.getDrugs().size(), "Inventory should contain 5 drugs!");
    }

    @Test
    public void testView() {
        List<Object>  listDrugs = inventory.View();

        assertEquals(5, listDrugs.size(), "The list should contains 5 drugs");
    }

    @Test
    public void testDetailedView() {

    }

    @Test
    public void testSearchByDin() {
        assertEquals(drugA, inventory.SearchByDin(drugA.getDin()), "It's supposed to be Forxiga");
        assertEquals(drugB, inventory.SearchByDin(drugB.getDin()), "It's supposed to be Jardiance");
        assertEquals(drugC, inventory.SearchByDin(drugC.getDin()), "It's supposed to be Ozempic");
        assertEquals(drugD, inventory.SearchByDin(drugD.getDin()), "It's supposed to be Trulicity");
        assertEquals(drugE, inventory.SearchByDin(drugE.getDin()), "It's supposed to be Xarelto");
        
        assertNull(inventory.SearchByDin(0), "There is no drug having that DIN!");
    }

    @Test
    public void testSearchByName() {
        assertEquals(drugA, inventory.SearchByName(drugA.getName()), "It's supposed to be Forxiga");
        assertEquals(drugB, inventory.SearchByName(drugB.getName()), "It's supposed to be Jardiance");
        assertEquals(drugC, inventory.SearchByName(drugC.getName()), "It's supposed to be Ozempic");
        assertEquals(drugD, inventory.SearchByName(drugD.getName()), "It's supposed to be Trulicity");
        assertEquals(drugE, inventory.SearchByName(drugE.getName()), "It's supposed to be Xarelto");
        assertNull(inventory.SearchByName("Hello"), "There is no drug having that DIN!");

    }

    @Test
    public void testSearchByIngredient() {
        assertEquals(drugA, inventory.SearchByIngredient(drugA.getIngredient()), "It's supposed to be Forxiga");
        assertEquals(drugB, inventory.SearchByIngredient(drugB.getIngredient()), "It's supposed to be Jardiance");
        assertEquals(drugC, inventory.SearchByIngredient(drugC.getIngredient()), "It's supposed to be Ozempic");
        assertEquals(drugD, inventory.SearchByIngredient(drugD.getIngredient()), "It's supposed to be Trulicity");
        assertEquals(drugE, inventory.SearchByIngredient(drugE.getIngredient()), "It's supposed to be Xarelto");
        assertNull(inventory.SearchByIngredient("Hello"), "There is no drug having that DIN!");
    }
}
