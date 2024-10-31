import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DurationTest {

    @Test
    void read() {
        String data = "04:23";
        Duration duration = Duration.read(data);

        assertEquals(data, duration.toString());
    }

    @Test
    void testEquals() {
        Duration duration1 = Duration.read("04:23");
        Duration duration2 = Duration.read("04:23");

        assertEquals(duration1, duration2);
    }

    @Test
    void testHashCode() {
        Duration duration1 = Duration.read("04:03");
        Duration duration2 = Duration.read("04:03");
        assertEquals(duration1.hashCode(), duration2.hashCode());
    }
}