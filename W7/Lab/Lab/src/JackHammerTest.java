import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JackHammerTest {

    @Test
    void testToString() {
        JackHammer jackHammer = new JackHammer("Power");
        Assertions.assertEquals("This JackHammer requires: Power\nPowerSupply: Air Compressor", jackHammer.toString());
    }

    @Test
    void testEquals() {
        JackHammer jackHammer = new JackHammer("Power");
        JackHammer jackHammer2 = new JackHammer("Power");
        Assertions.assertEquals(jackHammer, jackHammer2);
    }
}