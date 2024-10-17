import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {
    @Test
    public void testHashCode() {
        Teacher t1 = new Teacher("Andy", 180.0, 3);
        Teacher t2 = new Teacher("Andy", 180.0, 3);
        Teacher t3 = new Teacher("Andy", 180.0, 4);

        assertEquals(t1.hashCode(), t2.hashCode());

        assertNotEquals(t1.hashCode(), t3.hashCode());
    }

    @Test
    public void testEqualsSame() {
        Teacher t = new Teacher("Andy", 180.0, 3);

        assertEquals(t, t);
    }

    @Test
    public void testEqualsTwoObjects() {
        Teacher t1 = new Teacher("Andy", 180.0, 3);
        Teacher t2 = new Teacher("Andy", 180.0, 3);

        assertEquals(t1, t2);
    }

    @Test
    public void testEqualsFalse() {
        Teacher t1 = new Teacher("Tomas", 200.0, 3);
        Teacher t2 = new Teacher("Andy", 180.0, 2);

        assertNotEquals(t1, t2);
    }
}
