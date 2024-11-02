import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrizeBallTest {

    @Test
    void testToString() {
        String data = "Normal Prize Ball (white), contains Rhino.";
        PrizeBall pz = new PrizeBall("white", "", Rarity.NORMAL, "Rhino");

        assertEquals(data, pz.toString());
    }

    @Test
    void testEquals() {
        PrizeBall pz = new PrizeBall("white", "", Rarity.NORMAL, "Rhino");;
        PrizeBall pz2 = new PrizeBall("white", "", Rarity.NORMAL, "Rhino");;

        assertEquals(pz, pz2);
    }

    @Test
    void testHashCode() {
        PrizeBall pz = new PrizeBall("white", "", Rarity.NORMAL, "Rhino");
        PrizeBall pz2 = new PrizeBall("white", "", Rarity.NORMAL, "Rhino");

        assertEquals(pz.hashCode(), pz2.hashCode());
    }
}