package LiferayStore;

import java.util.ArrayList;
import java.util.List;

/** Create a basket class, which is a list that holds all the items parsed from the file in an ArrayList.
 * The class is final so that it cannot be extended or altered by other classes or methods.
 * The data variable is final so that it cannot be altered after creating an instance of Basket.
 */

public final class Basket {
    private final List<Item> items = new ArrayList<>();

    public Basket addItem(int quantity, String name, double price) {
        items.add(new Item(quantity, name, price));
        return this;
    }

    public List<Item> getItems() {
        return items;
    }
}
