package LiferayStore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    Basket basket;

    @BeforeEach
    void setUp() {
        basket = new Basket();
        basket.addItem(1, "book", 4.99);
        basket.addItem(1, "music CD", 3.99);
    }

    @Test
    void addItem() {

        assertNotNull(basket);
        assertEquals(2, basket.getItems().size());
    }

    @Test
    void getItems() {

        List<Item> items = basket.getItems();
        assertNotNull(items);
        assertEquals(2, items.size());

    }
}