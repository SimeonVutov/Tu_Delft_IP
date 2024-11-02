import java.util.Objects;

public class PrizeBall extends Ball{
    private Rarity rarity;
    private String selectedPrize;

    /**
     * Creates a new Prize Ball
     * @param colour colour
     * @param description description
     * @param rarity rarity of the ball
     * @param selectedPrize selected Prize for the ball
     */
    public PrizeBall(String colour, String description, Rarity rarity, String selectedPrize) {
        super(colour, description);
        this.rarity = rarity;
        this.selectedPrize = selectedPrize;
    }

    /**
     * Creates a copy of the object
     * @param prizeBall ball to copy
     */
    public PrizeBall(PrizeBall prizeBall) {
        this(
                prizeBall.colour,
                prizeBall.description,
                prizeBall.rarity,
                prizeBall.selectedPrize
        );
    }

    /**
     * Sets the prize of the ball
     * @param selectedPrize the prize that will be selected
     */
    public void setSelectedPrize(String selectedPrize) {
        this.selectedPrize = selectedPrize;
    }

    /**
     * Returns the rarity
     * @return rarity
     */
    public Rarity getRarity() {
        return rarity;
    }

    /**
     * Creates a text representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return String.format("""
                %s Prize Ball (%s), contains %s.""",
                rarity.toString(),
                colour,
                selectedPrize
        );
    }

    /**
     * Checks if the specified object is equal to this
     * @param o the object we check this with
     * @return true/false based on whether the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PrizeBall prizeBall = (PrizeBall) o;
        return rarity == prizeBall.rarity && Objects.equals(selectedPrize, prizeBall.selectedPrize);
    }

    /**
     * Creates a hashcode for the object
     * @return the hashcode that was generated
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rarity);
    }
}
