package LiferayStore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/** Create a basket class, which is a list that holds all the items parsed from the file in an ArrayList.
 * The sales and import tax for each item is calculated within the class.
 * The class is final so that it cannot be extended or altered by other classes or methods.
 * The data variable is final so that it cannot be altered after creating an instance of Basket.
 */

public final class Basket {

    private static final double importTax = 0.05;
    private static final double salesTax = 0.10;

    private final List<Item> items = new ArrayList<>();

    public Basket addItem(int quantity, String name, double price) {
        items.add(new Item(quantity, name, price));
        return this;
    }

    public static boolean hasSalesTax(Item item)
    {
        return Stream.of("book", "chocolate", "pills").noneMatch(item.name::contains);
    }

    public static boolean hasImportTax(Item item)
    {
        return item.name.contains("imported");
    }

    public List<Item> getItems() {
        return items;
    }

    // Method to round to the nearest 0.05 of a dollar
    public static double roundAmount(double amount) {
        return Math.round(amount * 20.0) / 20.0;
    }

    /** Print each item's name and price + applicable taxes (rounded to nearest 5 cents),
     * Print total taxes paid for all items,
     * Print basket total
     */
    public static void printOutput(Basket basket) {

        List<Item> items = basket.getItems();
        double basketTotalPrice = 0;
        double basketTotalTax = 0;

        for (Item item : items) {
            double itemPrice = item.price;
            double itemTaxRate = 0;

            if (hasSalesTax(item)) {
                itemTaxRate += salesTax;
            }
            if (hasImportTax(item)) {
                itemTaxRate += importTax;
            }
            double itemTax = roundAmount((itemPrice * item.quantity) * itemTaxRate);

            double itemTotalPrice = itemPrice + itemTax;
            System.out.printf("%d %s: %.2f%n", item.quantity, item.name, itemTotalPrice);

            basketTotalTax += itemTax;
            basketTotalPrice += itemTotalPrice;
        }

        System.out.printf("Sales Taxes: %.2f%n", basketTotalTax);
        System.out.printf("Total: %.2f%n", basketTotalPrice);
    }
}
