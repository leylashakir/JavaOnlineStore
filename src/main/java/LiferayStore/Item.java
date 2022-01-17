package LiferayStore;

/** Created an Item class.
 * The parameters used for the constructor are taken from the input files in the order they appear.
 * The class is final so that it cannot be extended or altered by other classes or methods.
 * The data variables are final so that they cannot be altered after creating an instance of Item.
 **/
public final class Item {
    public final int quantity;
    public final String name;
    public final double price;

    Item(int quantityIn, String itemNameIn, double priceIn) {
        quantity = quantityIn;
        name = itemNameIn;
        price = priceIn;
    }
}
