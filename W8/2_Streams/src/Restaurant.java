public class Restaurant extends Venue {

    private boolean hasVeganFood;

    /**
     * Creates a restaurant.
     *
     * @param name The name of the restaurant
     * @param location The location of the restaurant
     * @param stars The amount of stars the restaurant has
     * @param hasVeganFood Whether the restaurant has vegan food
     */
    public Restaurant(String name, String location, int stars, boolean hasVeganFood) {
        super(name, location, stars);
        this.hasVeganFood = hasVeganFood;
    }

    /**
     * Gets whether the restaurant has vegan food.
     *
     * @return True iff this restaurant serves vegan food
     */
    public boolean hasVeganFood() {
        return hasVeganFood;
    }

    /**
     * Checks whether an object is equal to this restaurant.
     *
     * @param other The other object
     * @return True iff the object is an identical restaurant
     */
    @Override
    public boolean equals(Object other) {
        if (!super.equals(other)) return false;
        Restaurant that = (Restaurant) other;
        return this.hasVeganFood == that.hasVeganFood;
    }

}
