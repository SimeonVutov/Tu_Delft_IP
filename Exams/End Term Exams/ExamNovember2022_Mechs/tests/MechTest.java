import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MechTest {

    @Test
    void testEquals() {
        Mech mech = new Mech(
                "Test",
                "category",
                1,
                new Stats(1, 1, 1, 1),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Mech mech2 = new Mech(
                "Test",
                "category",
                1,
                new Stats(1, 1, 1, 1),
                new ArrayList<>(),
                new ArrayList<>()
        );

        assertEquals(mech, mech2);
    }

    @Test
    void testHashCode() {
        Mech mech = new Mech(
                "Test",
                "category",
                1,
                new Stats(1, 1, 1, 1),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Mech mech2 = new Mech(
                "Test",
                "category",
                1,
                new Stats(1, 1, 1, 1),
                new ArrayList<>(),
                new ArrayList<>()
        );

        assertEquals(mech.hashCode(), mech2.hashCode());
    }

    @Test
    void testReadStats() {
        String data = "3ATK - 1DEF - 15HP - 4SPD";
        Stats stats = new Stats(3, 1, 15, 4);
        Stats stats2 = Mech.readStats(data);

        assertEquals(stats, stats2);
    }

    @Test
    void testRead() {
        String data = """
                MECH - Cloudwing - Bravo - 13568
                3ATK - 1DEF - 15HP - 4SPD
                strength: wind - weakness: poison""";
        Mech mech = Mech.read(data);
        Mech mech2 = new Mech(
                "Cloudwing",
                "Bravo",
                13568,
                new Stats(3, 1, 15, 4),
                List.of("wind"),
                List.of("poison")
        );

        assertEquals(mech2, mech);
    }

    @Test
    void testToString() {
        Mech mech = Mech.read("""
                MECH - Cloudwing - Bravo - 13568
                3ATK - 1DEF - 15HP - 4SPD
                strength: wind - weakness: poison""");
        String data = "Cloudwing (Category: Bravo)\n" +
                "It has 3 attack, 1 defence, 15 health, and 4 speed.\n" +
                "strength(s): wind, weakness(es): poison";

        assertEquals(data, mech.toString());
    }
}