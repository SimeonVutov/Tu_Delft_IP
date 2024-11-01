import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    void testRead() {
        String data = "(20, 70)";
        Range range = new Range(20, 70);
        Range range2 = Range.read(data);

        assertEquals(range, range2);
    }

    @Test
    void testToString() {
        Range range = new Range(1, 2);
        assertEquals("1cm and 2cm", range.toString());
    }

    @Test
    void testEquals() {
        Range range1 = new Range(1, 2);
        Range range2 = new Range(1, 2);

        assertEquals(range1, range2);
    }

    @Test
    void testHashCode() {
        Range range1 = new Range(1, 2);
        Range range2 = new Range(1, 2);
        assertEquals(range1.hashCode(), range2.hashCode());
    }
}