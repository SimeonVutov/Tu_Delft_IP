import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConcreteMixerTest {

    @Test
    void testToString() {
        ConcreteMixer concreteMixer = new ConcreteMixer("Water");
        Assertions.assertEquals("This concrete mixer requires: Water", concreteMixer.toString());
    }

    @Test
    void testEquals() {
        ConcreteMixer concreteMixer = new ConcreteMixer("Water");
        ConcreteMixer concreteMixer2 = new ConcreteMixer("Water");
        Assertions.assertEquals(concreteMixer, concreteMixer2);
    }
}