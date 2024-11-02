public class EmptyBall extends Ball{
    /**
     * Creates a new empty ball
     * @param colour the colour of the ball
     * @param description description
     */
    public EmptyBall(String colour, String description) {
        super(colour, description);
    }

    /**
     * Creates a text representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return String.format("""
                Empty ball (%s), contains... nothing.""",
                colour
        );
    }
}
