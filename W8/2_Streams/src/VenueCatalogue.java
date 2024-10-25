import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class VenueCatalogue {

    private List<Venue> venues;

    /**
     * Creates a venue catalogue.
     */
    public VenueCatalogue() {
        this.venues = new ArrayList<>();
    }

    /**
     * Gets the list of quality venues.
     *
     * @return The list of venues with 3 stars or more
     */
    public List<Venue> qualityVenues() {
        return venues.stream() // Stream<Venue>
                .filter(v -> v.getStars() > 3) //Stream<Venue>
                .toList(); // List<Venue>
    }

    /**
     * We want to know the quality of venues in Delft and
     * calculate the average amount of stars they have.
     * @return An optional with the average amount of stars
     */
    public OptionalDouble averageStars() {
        // Turn the into a stream --> Stream<Venue>
        // Map from venues to starts --> Stream<Venue>
        // ???? IntStream --> mapToInt()

        return venues.stream()
                .mapToInt(v -> v.getStars())
                .average();
    }

    public List<String> allUniqueMenuItems() {
        // List into Stream Stream<Venue>
        // venues into menu items
        return venues
                .stream()
                .flatMap(v -> v.getMenu().stream())
                .distinct()
                .toList();
    }

    /**
     * Gets the list of vegan restaurants names.
     *
     * @return The list of names of restaurants that have vegan menu options
     */
    public List<String> veganRestaurantNames() {
        // Turn list into a stream. Stream<Venue>
        // Filter stream on restaurants. Stream<Venue>
        // Map Stream<Venue> to Stream<Restaurant> Stream<Restaurant>
        // Filter on whether Restaurant has vegan food. Stream<Restaurant>
        // Map to name of venue Stream<Venue>
        // Turn the stream back to a list

        return venues.stream()
                .filter(v -> v instanceof Restaurant)
                .map(v -> (Restaurant)v)
                .filter(r -> r.hasVeganFood())
                .map(r -> r.getName())
                .toList();
    }

    /**
     * Gets the list of cheap drinking locations.
     *
     * @return The list of locations of bars where a beer costs less than 2 euros
     */
    public List<String> cheapDrinkingLocations() {
        // Turn list into a stream Stream<Venue>
        // Filter input on Bars Stream<Venue>
        // Map venues to Bar Stream<Bar>
        // Filter Bars on drinks that cost less than 2 euros Stream<Bar>
        // Map bars to locations Stream<String>
        // Stream back into a List<String>

        return venues.stream()
                .filter(v -> v instanceof Bar)
                .map(v -> (Bar)v)
                .filter(b -> b.getCostOfOneBeer() < 2.0)
                .map(b -> b.getLocation())
                .toList();

    }

    /**
     * Adds a venue to the catalogue.
     *
     * @param venue The venue to add
     */
    public void addVenue(Venue venue) {
        this.venues.add(venue);
    }

    /**
     * Gets the list of venues.
     *
     * @return The list of venues in this catalogue
     */
    public List<Venue> getVenues() {
        return venues;
    }

}
