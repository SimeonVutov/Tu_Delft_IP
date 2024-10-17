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
}
