/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package LiferayStore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final double importTax = 0.05;
    private static final double salesTax = 0.10;

    protected static boolean hasSalesTax(Item item)
    {
        for (String word : Arrays.asList("book", "chocolate", "pills")) {
            if (item.name.contains(word)) {
                return false;
            }
        }
        return true;
    }

    protected static boolean hasImportTax(Item item)
    {
        return item.name.contains("imported");
    }

    // Method to round to the nearest 0.05 of a dollar
    protected static double roundAmount(double amount) {
       return Math.round(amount * 20.0) / 20.0;
    }

    /** Method to calculate import and sales taxes for individual items,
     * total taxes for all items in the basket,
     * and total price of the basket with taxes to the nearest 5 cents.
     */
    protected static void printOutput(Basket basket) {
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
            double itemTax = (itemPrice * item.quantity) * itemTaxRate;

            double itemTotalPrice = itemPrice + itemTax;
            System.out.printf("%d %s: %.2f%n", item.quantity, item.name, roundAmount(itemTotalPrice));

            basketTotalTax += itemTax;
            basketTotalPrice += itemTotalPrice;
        }

        System.out.printf("Sales Taxes: %.2f%n", roundAmount(basketTotalTax));
        System.out.printf("Total: %.2f%n", roundAmount(basketTotalPrice));
    }

    // Builds a basket object from data in the file
    private static Basket readInput(String file) throws IOException
    {
        Basket basket = new Basket();
        try (Scanner inputScanner = new Scanner(new FileInputStream(file))) {
            while (inputScanner.hasNextLine()) {
                String line = inputScanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] words = line.split(" ");
                int quantity = Integer.parseInt(words[0]);
                double price = Double.parseDouble(words[words.length - 1]);
                String name = String.join(" ", Arrays.copyOfRange(words, 1, words.length - 2));
                basket.addItem(quantity, name, price);
            }
        }
        return basket;
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Usage: [LiferayStore] [filename]");
            System.exit(1);
        }
        Basket basket = readInput(args[0]);
        printOutput(basket);
    }
}