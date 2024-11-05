import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DefensiveEquipmentTest {

    @Test
    void testEquals() {
        DefensiveEquipment de = new DefensiveEquipment(
                "Test",
                1,
                new ArrayList<>(),
                new ArrayList<>(),
                1
        );
        DefensiveEquipment de2 = new DefensiveEquipment(
                "Test",
                1,
                new ArrayList<>(),
                new ArrayList<>(),
                1
        );

        assertEquals(de, de2);
    }

    @Test
    void testHashCode() {
        DefensiveEquipment de = new DefensiveEquipment(
                "Test",
                1,
                new ArrayList<>(),
                new ArrayList<>(),
                1
        );
        DefensiveEquipment de2 = new DefensiveEquipment(
                "Test",
                1,
                new ArrayList<>(),
                new ArrayList<>(),
                1
        );

        assertEquals(de.hashCode(), de2.hashCode());
    }

    @Test
    void testReadStat() {
        String data = "1DEF";

        assertEquals(1, DefensiveEquipment.readStat(data));
    }

    @Test
    void testToString() {
        String data = """
                Equipment: Leather Armor
                    category: DEFENSIVE
                    id: 43564
                    strengths: wind
                    weaknesses: none
                Defense Points: 1
                """;
        DefensiveEquipment de = new DefensiveEquipment(
                "Leather Armor",
                43564,
                List.of("wind"),
                new ArrayList<String>(),
                1
        );

        assertEquals(data, de.toString());
    }
}