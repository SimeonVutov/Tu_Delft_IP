import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {

    @Test
    void readStrengths() {
        String data = "strength: wind - weakness: poison";
        List<String> list = List.of("wind");

        assertEquals(list, DataReader.readStrengths(data));
    }

    @Test
    void readWeaknesses() {
        String data = "strength: wind - weakness: poison";
        List<String> list = List.of("poison");

        assertEquals(list, DataReader.readWeaknesses(data));
    }

    @Test
    void testReadMechs() {
        String data = """
                1
                MECH - Cloudwing - Bravo - 13568
                3ATK - 1DEF - 15HP - 4SPD
                strength: wind - weakness: poison""";
        var test = List.of(Mech.read(data.substring(2)));
        List<Mech> mechs = DataReader.readMechs(data);

        assertEquals(test, mechs);
    }

    @Test
    void testReadEquipments() {
        String data = """
                1
                MECH - Cloudwing - Bravo - 13568
                3ATK - 1DEF - 15HP - 4SPD
                strength: wind - weakness: poison
                1
                EQUIPMENT - Leather Armor - Defensive - 43564
                1DEF
                weakness: wind""";
        String normal = """
                EQUIPMENT - Leather Armor - Defensive - 43564
                1DEF
                weakness: wind""";
        DefensiveEquipment de = new DefensiveEquipment(
                "Leather Armor",
                43564,
                List.of("wind"),
                new ArrayList<String>(),
                1
        );
        var test = List.of(EquipmentFactory.readEquipment(normal));
        List<Equipment> equipment = DataReader.readEquipments(data);

        assertEquals(test, equipment);
    }
}