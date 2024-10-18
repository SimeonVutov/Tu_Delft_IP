import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void getStreetTest() {
        Address address = new Address("Roland", 100, "2634B", "Delft");
        assertEquals("Roland", address.getStreet());
    }

    @Test
    void getNumberTest() {
        Address address = new Address("Roland", 100, "2634B", "Delft");
        assertEquals(100, address.getNumber());
    }

    @Test
    void getZipcodeTest() {
        Address address = new Address("Roland", 100, "2634B", "Delft");
        assertEquals("2634B", address.getZipcode());
    }

    @Test
    void getCityTest() {
        Address address = new Address("Roland", 100, "2634B", "Delft");
        assertEquals("Delft", address.getCity());
    }

    @Test
    void testToString() {
        Address address = new Address("Roland", 100, "2634B", "Delft");
        assertEquals("Roland, 100, 2634B, Delft", address.toString());
    }

    @Test
    void testEquals() {
        Address address = new Address("Roland", 100, "2634B", "Delft");
        Address address2 = new Address("Roland", 100, "2634B", "Delft");
        assertEquals(address, address2);
    }
}