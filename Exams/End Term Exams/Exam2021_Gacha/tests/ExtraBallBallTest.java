import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtraBallBallTest {

    @Test
    void testEquals() {
        ExtraBallBall ebb = new ExtraBallBall("light green", "", 2);
        ExtraBallBall ebb2 = new ExtraBallBall("light green", "", 2);

        assertEquals(ebb, ebb2);
    }

    @Test
    void testHashCode() {
        ExtraBallBall ebb = new ExtraBallBall("light green", "", 2);
        ExtraBallBall ebb2 = new ExtraBallBall("light green", "", 2);

        assertEquals(ebb.hashCode(), ebb2.hashCode());
    }

    @Test
    void testToString() {
        String data = "Extra Ball Ball (light green), gives 2 extra draws.";
        ExtraBallBall ebb = new ExtraBallBall("light green", "", 2);

        assertEquals(data, ebb.toString());
    }
}