import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    void getStreetTest() {
        Address address = new Address("Roland", 100, "2634B", "Delft");
        Assertions.assertEquals("Roland", address.getStreet());
    }

    @Test
    void getNumberTest() {
        Address address = new Address("Roland", 100, "2634B", "Delft");
        Assertions.assertEquals(100, address.getNumber());
    }

    @Test
    void getZipcodeTest() {
        Address address = new Address("Roland", 100, "2634B", "Delft");
        Assertions.assertEquals("2634B", address.getZipcode());
    }

    @Test
    void getCityTest() {
        Address address = new Address("Roland", 100, "2634B", "Delft");
        Assertions.assertEquals("Delft", address.getCity());
    }

    @Test
    void testFromData() {
        String stringToParse = "Roland; 123; 4325B; Delft";
        Address address = Address.fromData(stringToParse);
        Address address2 = new Address("Roland", 123, "4325B", "Delft");

        Assertions.assertEquals(address, address2);
    }

    @Test
    void testSerialize() {
        String data = "Roland; 123; 4325B; Delft";
        Address address = new Address("Roland", 123, "4325B", "Delft");
        Assertions.assertEquals(data, address.serialize());
    }

    @Test
    void testToString() {
        Address address = new Address("Roland", 100, "2634B", "Delft");
        Assertions.assertEquals("Roland, 100, 2634B, Delft", address.toString());
    }

    @Test
    void testEquals() {
        Address address = new Address("Roland", 100, "2634B", "Delft");
        Address address2 = new Address("Roland", 100, "2634B", "Delft");
        Assertions.assertEquals(address, address2);
    }
}