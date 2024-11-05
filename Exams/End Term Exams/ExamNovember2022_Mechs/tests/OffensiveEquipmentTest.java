import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OffensiveEquipmentTest {

    @Test
    void testEquals() {
        OffensiveEquipment oe = new OffensiveEquipment(
                "Test",
                1,
                new ArrayList<>(),
                new ArrayList<>(),
                1
        );
        OffensiveEquipment oe2 = new OffensiveEquipment(
                "Test",
                1,
                new ArrayList<>(),
                new ArrayList<>(),
                1
        );

        assertEquals(oe, oe2);
    }

    @Test
    void testHashCode() {
        OffensiveEquipment oe = new OffensiveEquipment(
                "Test",
                1,
                new ArrayList<>(),
                new ArrayList<>(),
                1
        );
        OffensiveEquipment oe2 = new OffensiveEquipment(
                "Test",
                1,
                new ArrayList<>(),
                new ArrayList<>(),
                1
        );

        assertEquals(oe.hashCode(), oe2.hashCode());
    }

    @Test
    void testReadStat() {
        String data = "1ATK";

        assertEquals(1, OffensiveEquipment.readStat(data));
    }

    @Test
    void testToString() {
        String data = """
                Equipment: Rusted Spear
                    category: OFFENSIVE
                    id: 13568
                    strengths: none
                    weaknesses: none
                Attack Points: 1
                """;
        OffensiveEquipment oe = new OffensiveEquipment(
                "Rusted Spear",
                13568,
                new ArrayList<String>(),
                new ArrayList<String>(),
                1
        );

        assertEquals(data, oe.toString());
    }
}