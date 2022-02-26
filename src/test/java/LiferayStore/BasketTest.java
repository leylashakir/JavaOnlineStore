package LiferayStore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    Basket basket;
    List<Item> items;

    @BeforeEach
    void setUp() {
        basket = new Basket();
        basket.addItem(1, "book", 4.99);
        basket.addItem(1, "music CD", 3.99);
        basket.addItem(1, "imported chocolate", 3.99);
        items = basket.getItems();
    }

    @Test
    void testAddItem() {
        assertEquals(3, items.size());
    }

    @Test
    void testGetItems() {
        assertEquals(items, items);
    }

    @Test
    void testHasSalesTax() {
        assertTrue(basket.hasSalesTax(items.get(1)));
        assertFalse(basket.hasSalesTax(items.get(2)));
    }

    @Test
    void testHasImportTax() {
        assertFalse(basket.hasImportTax(items.get(1)));
        assertTrue(basket.hasImportTax(items.get(2)));
    }

    @Test
    void testRoundAmount() {
        double amount = 53.33;
        assertEquals(53.35, Basket.roundAmount(amount));

        amount = 53.31;
        assertEquals(53.30, Basket.roundAmount(amount));
    }
}