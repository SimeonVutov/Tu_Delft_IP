import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdTest {

    @Test
    void testToString() {
        String data = "AD ING Bank; 00:20; 0.05 euros";
        Ad ad = new Ad(new Duration(0, 20), "ING Bank", 0.05);

        assertEquals(data, ad.toString());
    }

    @Test
    void read() {
        String data = """
                AD ING Bank; 00:20; 0.05 euros
                """.stripIndent();
        Ad ad = new Ad(new Duration(0, 20), "ING Bank", 0.05);
        Ad ad2 = Ad.read(data);

        assertEquals(ad, ad2);
    }

    @Test
    void testHashCode() {
        String data = """
                AD ING Bank; 00:20; 0.05 euros
                """.stripIndent();
        Ad ad = new Ad(new Duration(0, 20), "ING Bank", 0.05);
        Ad ad2 = Ad.read(data);

        assertEquals(ad.hashCode(), ad2.hashCode());
    }
}