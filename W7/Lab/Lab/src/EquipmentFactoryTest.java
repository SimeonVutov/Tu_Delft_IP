import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EquipmentFactoryTest {

    @Test
    void testCorrectCreationJackHammer() {
        String data = "JackHammer, A hardened chisel";
        Equipment equipment = EquipmentFactory.createEquipment(data);

        Assertions.assertEquals("JackHammer", equipment.getClass().getSimpleName().toString());
    }

    @Test
    void testCorrectSerialization() {
        String data = "JackHammer, A hardened chisel;";
        JackHammer jh = new JackHammer("A hardened chisel");

        Assertions.assertEquals(data, jh.serialize());
    }
}