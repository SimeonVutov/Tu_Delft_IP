import java.util.Objects;
import java.util.Optional;

public abstract class Plant {
    protected String name;
    protected String latinName;
    protected Range sizeRange;
    protected Optional<FlowerDetails> flowerDetails;

    /**
     * Creates a new Plant object
     * @param name name
     * @param latinName latin name
     * @param sizeRange range
     * @param flowerDetails flower details
     */
    public Plant(String name, String latinName, Range sizeRange, FlowerDetails flowerDetails) {
        this.name = name;
        this.latinName = latinName;
        this.sizeRange = sizeRange;
        this.flowerDetails = Optional.ofNullable(flowerDetails);
    }

    /**
     * Creates a simple string representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return String.format(
                """
                named %s (latin: %s), typical size between %s.
                %s""",
                name,
                latinName,
                sizeRange.toString(),
                flowerDetails.map(FlowerDetails::toString).orElse(
                        "This plant does not have flowers."
                )
        );
    }

    /**
     * Checks if the given object is equal to this object
     * @param o the object that we are going to compare this to
     * @return true/false based on whether the objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return Objects.equals(name, plant.name) &&
                Objects.equals(latinName, plant.latinName) &&
                Objects.equals(sizeRange, plant.sizeRange) &&
                Objects.equals(flowerDetails, plant.flowerDetails);
    }

    /**
     * Creates a hashcode
     * @return a hashcode for the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, latinName, sizeRange, flowerDetails);
    }
}
