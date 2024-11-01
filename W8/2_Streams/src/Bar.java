public class Bar extends Venue {

    private double costOfOneBeer;
    private int amountOfDifferentDrinks;

    /**
     * Creates a bar.
     *
     * @param name The name of the bar
     * @param location The location of the bar
     * @param stars The amount of stars this bar has
     * @param costOfOneBeer The cost of one beer at this bar
     * @param amountOfDifferentDrinks The amount of different drinks this bar serves
     */
    public Bar(String name, String location, int stars, double costOfOneBeer, int amountOfDifferentDrinks) {
        super(name, location, stars);
        this.costOfOneBeer = costOfOneBeer;
        this.amountOfDifferentDrinks = amountOfDifferentDrinks;
    }

    /**
     * Gets the cost of one beer.
     *
     * @return The cost of one beer at this bar
     */
    public double getCostOfOneBeer() {
        return costOfOneBeer;
    }

    /**
     * Gets the amount of different drinks.
     *
     * @return The amount of different drinks this bar serves
     */
    public int getAmountOfDifferentDrinks() {
        return amountOfDifferentDrinks;
    }

    /**
     * Checks whether an object is equal to this bar.
     *
     * @param other The other object
     * @return True iff the object is an identical bar
     */
    @Override
    public boolean equals(Object other) {
        if (!super.equals(other)) return false;
        Bar that = (Bar) other;
        return this.costOfOneBeer == that.costOfOneBeer && this.amountOfDifferentDrinks == that.amountOfDifferentDrinks;
    }

}
