import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.*;

class VenueCatalogueTest {
    private VenueCatalogue catalogue;

    public VenueCatalogueTest() {
        catalogue = new VenueCatalogue();

        catalogue.addVenue(new Venue("Test", "Delft", 3));
    }

    @Test
    void averageStars() {
        OptionalDouble possibleAverage = catalogue.averageStars();

        assertTrue(possibleAverage.isPresent());
        assertEquals(3, possibleAverage.getAsDouble());
    }
}