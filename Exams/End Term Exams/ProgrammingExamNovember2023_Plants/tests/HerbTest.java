import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class HerbTest {

    @Test
    void testRead() {
        String data = "White mustard; Sinapis alba; (20, 70)\n" +
                "FLOWER DETAILS: yellow; small; 4 petals\n" +
                "EDIBILITY: Yes; strong, pungent, somewhat bitter and slightly sweet";
        Herb herb = Herb.read(data);

        Herb herb2 = new Herb(
                "White mustard",
                "Sinapis alba",
                new Range(20, 70),
                new FlowerDetails("yellow", FlowerSize.small, 4),
                true,
                "strong, pungent, somewhat bitter and slightly sweet"
        );

        assertEquals(herb2, herb);
    }

    @Test
    void testToString() {
        String name = "Basil";
        String latin = "Ocimum basilicum";
        Range range = new Range(30, 150);
        FlowerDetails fd = new FlowerDetails("white", FlowerSize.small, 5);
        boolean safe = true;
        String smell = "Savory and sweet with mint and pepper notes.";

        Plant plant = new Herb(name, latin, range, fd, safe, smell);
        String data = "Herb named Basil (latin: Ocimum basilicum), typical size between 30cm and 150cm.\n" +
                "This plant has small, white flowers with 5 petals.\n" +
                "This herb is safe to eat. Savory and sweet with mint and pepper notes.";
        assertEquals(data, plant.toString());
    }

    @Test
    void testEquals() {
        String name = "Basil";
        String latin = "Ocimum basilicum";
        Range range = new Range(30, 150);
        FlowerDetails fd = new FlowerDetails("white", FlowerSize.small, 5);
        boolean safe = true;
        String smell = "Savory and sweet with mint and pepper notes.";

        Plant plant = new Herb(name, latin, range, fd, true, smell);
        Plant plant2 = new Herb(name, latin, range, fd, false, smell);

        assertNotEquals(plant, plant2);
    }

    @Test
    void testHashCode() {
        String name = "Basil";
        String latin = "Ocimum basilicum";
        Range range = new Range(30, 150);
        FlowerDetails fd = new FlowerDetails("white", FlowerSize.small, 5);
        boolean safe = true;
        String smell = "Savory and sweet with mint and pepper notes.";

        Plant plant = new Herb(name, latin, range, fd, true, smell);
        Plant plant2 = new Herb(name, latin, range, fd, true, smell);

        assertEquals(plant.hashCode(), plant2.hashCode());
    }
}