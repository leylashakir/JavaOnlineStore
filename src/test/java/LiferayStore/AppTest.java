package LiferayStore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AppTest extends App {

    Basket basket;
    List<Item> items;


    @BeforeEach
    void setUp() {
        basket = new Basket();
        basket.addItem(1, "book", 4.99);
        basket.addItem(1, "music CD", 3.99);
        basket.addItem(1, "imported perfume", 5.99);
        items = basket.getItems();
    }

    @Test
    void hasImportTax() {
        assertTrue(hasImportTax(items.get(2)));
        assertFalse(hasImportTax(items.get(1)));
    }

    @Test
    void hasSalesTax() {
        assertTrue(hasSalesTax(items.get(2)));
        assertFalse(hasSalesTax(items.get(0)));
    }

    @Test
    void roundAmount() {
        double amount = 53.33;
        assertEquals(53.35, roundAmount(amount));

        amount = 52.41;
        assertEquals(52.40, roundAmount(amount));
    }

}