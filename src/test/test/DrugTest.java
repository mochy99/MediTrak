package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Drug;
import main.model.ExpirationInfo;

public class DrugTest {
    private Drug testDrugA;
    private String lotA = "A20669";
    private String lotB = "A20668";
    private String lotC = "A20670";
    private Date oldExp = Date.valueOf(LocalDate.of(2027, 12, 31)); 
    private Date newExp = Date.valueOf(LocalDate.of(2028, 8, 31)); 
    ExpirationInfo expirationInf;

    @BeforeEach
    public void runBefore() { // Add public keyword
        expirationInf = new ExpirationInfo(oldExp, lotA, 30.0);
        testDrugA = new Drug(123, "Forxiga", "Dapaglifozin", 10, 
                            "tab", "AZ", "RXB", expirationInf, 
                            109.75, 0.2);
    }

    @Test
    public void testPurchase() {
        assertEquals(30.0, testDrugA.getTotalQuantity());

        testDrugA.purchase(90, lotA, oldExp);

        assertEquals(120, testDrugA.getTotalQuantity());
        assertEquals(120, testDrugA.getQuantityByExp(oldExp));
        assertEquals(120, testDrugA.getQuantityByLot(lotA));
        assertEquals(lotA, testDrugA.getCurrentLot());
        System.out.println(testDrugA.getExpirationInfos());
        assertEquals(oldExp, testDrugA.getCurrentExp());
    }

    @Test
    public void testPurchaseMultipleLotsOnSameDrug() {
        assertEquals(30.0, testDrugA.getTotalQuantity());

        testDrugA.purchase(90, lotA, oldExp);

        assertEquals(120, testDrugA.getTotalQuantity());
        assertEquals(120, testDrugA.getQuantityByExp(oldExp));
        assertEquals(120, testDrugA.getQuantityByLot(lotA));
        assertEquals(lotA, testDrugA.getCurrentLot());
        assertEquals(oldExp, testDrugA.getCurrentExp());

        testDrugA.purchase(30, lotC, newExp);

        assertEquals(150, testDrugA.getTotalQuantity());
        assertEquals(120, testDrugA.getQuantityByExp(oldExp));
        assertEquals(120, testDrugA.getQuantityByLot(lotA));
        assertEquals(30, testDrugA.getQuantityByExp(newExp));
        assertEquals(30, testDrugA.getQuantityByLot(lotC));
        assertEquals(lotA, testDrugA.getCurrentLot());
        assertEquals(oldExp, testDrugA.getCurrentExp());

        testDrugA.purchase(30, lotB, oldExp);

        assertEquals(180, testDrugA.getTotalQuantity());
        assertEquals(150, testDrugA.getQuantityByExp(oldExp));
        assertEquals(120, testDrugA.getQuantityByLot(lotA));
        assertEquals(30, testDrugA.getQuantityByLot(lotB));
        assertEquals(30, testDrugA.getQuantityByExp(newExp));
        assertEquals(30, testDrugA.getQuantityByLot(lotC));
        assertEquals(lotB, testDrugA.getCurrentLot());
        assertEquals(oldExp, testDrugA.getCurrentExp());
    }
}
