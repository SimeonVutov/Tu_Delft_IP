import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JackHammerTest {

    @Test
    void testToString() {
        JackHammer jackHammer = new JackHammer("Power");
        assertEquals("This JackHammer requires: Power", jackHammer.toString());
    }

    @Test
    void testEquals() {
        JackHammer jackHammer = new JackHammer("Power");
        JackHammer jackHammer2 = new JackHammer("Power");
        assertEquals(jackHammer, jackHammer2);
    }
}