import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VenueCatalogueTest {

    private Venue v1, v2, v3, v4, v5,v6, v7, v8, v9;
    private VenueCatalogue catalogue;

    @BeforeEach
    void setUp() {
        v1 = new Restaurant("Delfts Brouwhuis", "City Centre", 4, true);
        v2 = new Bar("Doerak", "City Centre", 5, 3.5, 50);
        v3 = new Restaurant("Dominos", "De Hoven", 2, true);
        v4 = new Restaurant("KFC", "Delft North", 1, false);
        v5 = new Bar("/Pub", "Campus", 3, 1.25, 10);
        v6 = new Bar("De Botanie", "City Centre", 4, 3.9, 30);
        v7 = new Bar("The Hangout", "Campus", 3, 2.0, 12);
        v8 = new Restaurant("Umai", "City Centre", 4, true);
        v9 = new Restaurant("De Ark", "City Centre", 5, true);

        catalogue = new VenueCatalogue();
        catalogue.addVenue(v1);
        catalogue.addVenue(v2);
        catalogue.addVenue(v3);
        catalogue.addVenue(v4);
        catalogue.addVenue(v5);
        catalogue.addVenue(v6);
        catalogue.addVenue(v7);
        catalogue.addVenue(v8);
        catalogue.addVenue(v9);
    }

    @Test
    void qualityVenues() {
        assertEquals(List.of(v1, v2, v5, v6, v7, v8, v9), catalogue.qualityVenues());
    }

    @Test
    void veganRestaurantNames() {
        assertEquals(List.of("Delfts Brouwhuis", "Dominos", "Umai", "De Ark"), catalogue.veganRestaurantNames());
    }

    @Test
    void cheapDrinkingLocations() {
        assertEquals(List.of("Campus"), catalogue.cheapDrinkingLocations());
    }

}
