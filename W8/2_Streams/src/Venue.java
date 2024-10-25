import java.util.List;
import java.util.Objects;

public class Venue {

    private String name;
    private String location;
    private int stars;
    private List<String> menuItems;

    /**
     * Creates a venue.
     *
     * @param name The name of the venue
     * @param location The location of the venue
     * @param stars The amount of stars the venue has
     */
    public Venue(String name, String location, int stars) {
        this.name = name;
        this.location = location;
        this.stars = stars;
    }

    /**
     * Gets the name of the venue.
     *
     * @return This venue's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the location of the venue.
     *
     * @return This venue's location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the amount of stars the venue has.
     *
     * @return The amount of starts this venue has
     */
    public int getStars() {
        return stars;
    }

    public List<String> getMenu() {
        return menuItems;
    }

    /**
     * Checks whether an object is equal to this venue.
     *
     * @param other The other object
     * @return True iff the object is an identical venue
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) return false;
        Venue that = (Venue) other;
        return Objects.equals(this.name, that.name) && Objects.equals(this.location, that.location) && this.stars == that.stars;
    }

}
