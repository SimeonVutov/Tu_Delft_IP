import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentFactoryTest {

    @Test
    void testCorrectCreationJackHammer() {
        String data = "JackHammer, A hardened chisel";
        Equipment equipment = EquipmentFactory.createEquipment(data);

        assertEquals("JackHammer", equipment.getClass().getSimpleName().toString());
    }
}