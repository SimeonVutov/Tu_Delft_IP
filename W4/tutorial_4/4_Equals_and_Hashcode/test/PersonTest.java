import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    public void testHashCode() {
        Person p1 = new Person("Andy", 180.0);
        Person p2 = new Person("Andy", 180.0);
        Person p3 = new Person("Andy", 175.0);

        assertEquals(p1.hashCode(), p2.hashCode());

        assertNotEquals(p1.hashCode(), p3.hashCode());
    }

    @Test
    public void testEqualsSame() {
        Person p = new Person("Andy", 180.0);

        assertEquals(p, p);
    }

    @Test
    public void testEqualsTwoObjects() {
        Person p1 = new Person("Andy", 180.0);
        Person p2 = new Person("Andy", 180.0);

        assertEquals(p1, p2);
    }

    @Test
    public void testEqualsFalse() {
        Person p1 = new Person("Tomas", 200.0);
        Person p2 = new Person("Andy", 180.0);

        assertNotEquals(p1, p2);
    }
}
