import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentFactoryTest {

    @Test
    void readEquipment() {
        String data = "EQUIPMENT - Leather Armor - Defensive - 43564\n" +
                "1DEF\n" +
                "weakness: wind";
        DefensiveEquipment de = new DefensiveEquipment(
                "Leather Armor",
                43564,
                new ArrayList<>(),
                List.of("wind"),
                1
        );
        Equipment de2 = EquipmentFactory.readEquipment(data);

        assertEquals(de, de2);
    }
}