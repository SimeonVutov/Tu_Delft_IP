import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * StudentTest
 */
public class StudentTest {

    @Test
    public void testWillPassExam_true() {
        Student s = new Student("Andy", 180, true);
        s.study();
        s.study();
        s.study();
        s.study();
        s.study();
        assertEquals(true, s.willPassExam());
    }

    @Test
    public void testWillPassExam_false() {
        Student s = new Student("Andy", 180, false);
        assertEquals(false, s.willPassExam());
    }

    @Test
    public void testStudyIncrease() {
        Student s = new Student("Andy", 180, true);
        s.study();
        assertEquals(1, s.getTimesStudyed());
    }

    @Test
    public void testGetLivesInDelft() {
        Student s = new Student("Andy", 180, true);
        assertEquals(true, s.getLivesInDelft());
    }

    @Test
    public void testSetLivesInDelft() {
        Student s = new Student("Andy", 180, false);
        s.setLivesInDelft(true);
        assertEquals(true, s.getLivesInDelft());
    }

    @Test
    public void testHashCode() {
        Student s = new Student("Andy", 180, true);
        Student s2 = new Student("Andy", 180, true);
        Student s3 = new Student("Andy", 180, false);

        assertEquals(s.hashCode(), s.hashCode());

        assertEquals(s.hashCode(), s2.hashCode());

        assertNotEquals(s.hashCode(), s3.hashCode());
    }

    @Test
    public void testEqualsSame() {
        Student s = new Student("Andy", 180, true);

        assertEquals(s, s);
    }

    @Test
    public void testEqualsTwoObjects() {
        Student s = new Student("Andy", 180, true);
        Student s2 = new Student("Andy", 180, true);

        assertEquals(s, s2);
    }

    @Test
    public void testEqualsFalse() {
        Student s = new Student("Tomas", 200, true;
        Student s2 = new Student("Andy", 180, false);

        assertNotEquals(s, s2);
    }
}
