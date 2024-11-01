import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ShrubTest {

    @Test
    void testRead() {
        String data = "SHRUB: test; Test Latin; (100, 200)\n" +
                "FLOWER DETAILS: green; small; 5 petals";
        Shrub shrub = Shrub.read(data);

        Shrub shrub2 = new Shrub(
                "test",
                "Test Latin",
                new Range(100, 200),
                new FlowerDetails("green", FlowerSize.small, 5)
        );

        assertEquals(shrub2, shrub);
    }

    @Test
    void testToString() {
        String data = "Shrub named Pine (latin: Pinus), typical size between 100cm and 200cm.\n" +
                "This plant does not have flowers.";
        String name = "Pine";
        String latin = "Pinus";
        Range range = new Range(100, 200);
        FlowerDetails fd = null;

        Shrub shrub = new Shrub(
                name,
                latin,
                range,
                fd
        );

        assertEquals(data, shrub.toString());
    }
}