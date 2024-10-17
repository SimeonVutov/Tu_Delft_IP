import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TorchTest {
    @Test
    public void testRequirements() {
        Torch t = new Torch("Batteries");
        assertEquals("This torch requires: Batteries", t.toString());
    }

    @Test
    public void testToString() {
        Torch t = new Torch("Batteries");
        assertEquals("This torch requires: Batteries", t.toString());
    }

    @Test
    public void testEquals() {
        Torch t = new Torch("Batteries");
        Torch t2 = new Torch("Batteries");
        assertEquals(t, t2);
    }
    }
