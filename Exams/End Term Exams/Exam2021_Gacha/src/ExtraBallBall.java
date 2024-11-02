import java.util.Objects;

public class ExtraBallBall extends Ball{
    private int amountOfExtraBalls;

    /**
     * Creates a new Extra Ball Ball object
     * @param colour the colour of the ball
     * @param description the description of the ball
     * @param amountOfExtraBalls amount of extra balls
     */
    public ExtraBallBall(String colour, String description, int amountOfExtraBalls) {
        super(colour, description);
        this.amountOfExtraBalls = amountOfExtraBalls;
    }

    /**
     * Returns the amount of extra balls
     * @return the amount of extra balls
     */
    public int getAmountOfExtraBalls() {
        return amountOfExtraBalls;
    }

    /**
     * Sets the amount of balls to draw
     * @param amountOfExtraBalls amount of extra balls to draw
     */
    public void setAmountOfExtraBalls(int amountOfExtraBalls) {
        this.amountOfExtraBalls = amountOfExtraBalls;
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
        ExtraBallBall that = (ExtraBallBall) o;
        return amountOfExtraBalls == that.amountOfExtraBalls;
    }

    /**
     * Creates a hashcode for the object
     * @return the hashcode that was generated
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amountOfExtraBalls);
    }

    /**
     * Creates a text representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return String.format(
                """
                Extra Ball Ball (%s), gives %d extra draws.""",
                this.colour,
                this.amountOfExtraBalls
        );
    }
}
