package edu.ucsb.cs56.pconrad.menuitem;

public class MenuItem {

    private String name;
    private int priceInCents;
    private String category;

    /**
     * Custom exception thrown when getPrice is called with a width
     * that is too narrow for the formatted price.
     */

    public static class TooNarrowException extends RuntimeException {
    }


    public MenuItem(String name, int priceInCents, String category) {
        this.name = name;
        this.priceInCents = priceInCents;
        this.category = category;
    }

    /**
     * Returns the price, formatted as a string with a $.
     * For example "$0.99", "$10.99", or "$3.50"
     */

    public String getPrice() {
        double priceInDollar = this.priceInCents / 100.0;
        return "$"+Double.toString(priceInDollar);
    }

    /**
     * Returns the price, formatted as a string with a $,
     * right justified in a field with the specified width.
     * For example "$0.99", "$10.99", or "$3.50".
     * <p>
     * If the width is too small, throws IllegalArgumentException
     *
     * @param width width of returned string
     */

    public String getPrice(int width) {
        String price = this.getPrice();
        if (price.length() > width) {
            throw new TooNarrowException();
        }

        return String.format("%" + width + "s",price);
    }

    /**
     * @return the priceInCents
     */
    public int getPriceInCents() {
        return priceInCents;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * return a string in csv format, in the order name,price,cateogry.
     * For example <code>Small Poke Bowl,1049,Poke Bowls</code>
     *
     * @return string in csv format
     */

    @Override
    public String toString() {
        return String.format("%s,%d,%s",this.name, this.priceInCents, this.category);
    }

}
