import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyBallTest {

    @Test
    void testToString() {
        String data = "Empty ball (red), contains... nothing.";
        EmptyBall emptyBall = new EmptyBall("red", "");

        assertEquals(data, emptyBall.toString());
    }
}