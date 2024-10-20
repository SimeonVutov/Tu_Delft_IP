import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMixerTest {

    @Test
    void testToString() {
        ConcreteMixer concreteMixer = new ConcreteMixer("Water");
        assertEquals("This concrete mixer requires: Water", concreteMixer.toString());
    }

    @Test
    void testEquals() {
        ConcreteMixer concreteMixer = new ConcreteMixer("Water");
        ConcreteMixer concreteMixer2 = new ConcreteMixer("Water");
        assertEquals(concreteMixer, concreteMixer2);
    }
}