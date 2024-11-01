import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlantCollectionTest {

    String data = """
            HERB: White mustard; Sinapis alba; (20, 70)
            FLOWER DETAILS: yellow; small; 4 petals
            EDIBILITY: Yes; strong, pungent, somewhat bitter and slightly sweet
            TREE: Pine; Pinus; (300, 8000)
            TREE: Oshima cherry; Prunus speciosa; (400, 1200)
            FLOWER DETAILS: white; medium; 5 petals""";
    PlantCollection plantCollection1 = new PlantCollection(
            PlantCollection.readPlants(data)
    );
    PlantCollection plantCollection2 = new PlantCollection(
            PlantCollection.readPlants(data)
    );
    @Test
    void getPlantBeforeNext() {
        String data = """
                FLOWER DETAILS: yellow; small; 4 petals
                EDIBILITY: Yes; strong, pungent, somewhat bitter and slightly sweet
                TREE: Pine; Pinus; (300, 8000)""";
        String requiredData = """
                FLOWER DETAILS: yellow; small; 4 petals
                EDIBILITY: Yes; strong, pungent, somewhat bitter and slightly sweet""";
        Scanner sc = new Scanner(data);

        String plantData = PlantCollection.getPlantBeforeNext(sc);

        assertEquals(requiredData, plantData);
    }

    @Test
    void resetFilters() {
        plantCollection1.resetFilters();
        plantCollection2.resetFilters();

        assertEquals(plantCollection1, plantCollection2);
    }

    @Test
    void testEquals() {
        plantCollection1.resetFilters();
        plantCollection2.resetFilters();

        assertEquals(plantCollection1, plantCollection2);
    }

    @Test
    void testHashCode() {
        plantCollection1.resetFilters();
        plantCollection2.resetFilters();

        assertEquals(plantCollection1.hashCode(), plantCollection2.hashCode());
    }
}