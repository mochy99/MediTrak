package test.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach; // JUnit 5
import org.junit.jupiter.api.Test; // JUni

import main.model.ExpirationInfo;
import main.model.Drug;

public class MedicineTest {
    private Drug testMedicine;
    private String lot = "A20669";
    private Date exp = Date.valueOf(LocalDate.of(2028, 8, 31)); 
    private Date newExp = Date.valueOf(LocalDate.of(2029, 10, 31));
    ExpirationInfo expirationInf;

    @BeforeEach
    public void runBefore() {
        expirationInf = new ExpirationInfo(exp, lot, 30.0);
        testMedicine = new Drug(123, "Forxiga", "Dapaglifozin", 
                                10, "tab", "AZ", 
                                "RXB", expirationInf, 109.75, 0.2);
    }

    @Test 
    public void testConstructor() {
        assertEquals(123, testMedicine.getDin());
        assertEquals("Forxiga", testMedicine.getName());
        assertEquals("Dapaglifozin", testMedicine.getIngredient());
        assertEquals(10, testMedicine.getStrength());
        assertEquals("tab", testMedicine.getFormula());
        assertEquals("AZ", testMedicine.getManufacturer());
        assertEquals("RXB", testMedicine.getCategory());
        assertEquals(109.75, testMedicine.getPrice());
        assertEquals(0.2, testMedicine.getMarkup());

        testMedicine.setManufacturer("GSK");
        assertEquals("GSK", testMedicine.getManufacturer());

        testMedicine.setCategory("RXG");
        assertEquals("RXG", testMedicine.getCategory());

        testMedicine.setPrice(120.65);
        assertEquals(120.65, testMedicine.getPrice());

        testMedicine.setMarkup(0.25);
        assertEquals(0.25, testMedicine.getMarkup());  

        assertEquals(30, testMedicine.getTotalQuantity());
        assertEquals(30, testMedicine.getQuantityByExp(exp));
        assertEquals(30, testMedicine.getQuantityByLot(lot));
        assertEquals(0, testMedicine.getQuantityByExp(newExp));
        assertEquals(0, testMedicine.getQuantityByLot("A23084"));

        assertEquals(exp, testMedicine.getCurrentExp());
        assertEquals(lot, testMedicine.getCurrentLot());
    }
}
