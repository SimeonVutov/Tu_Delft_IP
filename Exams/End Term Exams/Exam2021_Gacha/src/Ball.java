import java.util.Objects;

public abstract class Ball {
    protected String colour;
    protected String description;

    /**
     * Creates a new Ball object
     * @param colour the colour of the ball
     * @param description the description of the ball
     */
    public Ball(String colour, String description) {
        this.colour = colour;
        this.description = description;
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
        Ball ball = (Ball) o;
        return Objects.equals(colour, ball.colour) && Objects.equals(description, ball.description);
    }

    /**
     * Creates a hashcode for the object
     * @return the hashcode that was generated
     */
    @Override
    public int hashCode() {
        return Objects.hash(colour, description);
    }
}
