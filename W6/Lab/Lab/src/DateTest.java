import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void getDay() {
        Date date = new Date(1, 1, 2000);
        assertEquals(1, date.getDay());
    }

    @Test
    void getMonth() {
        Date date = new Date(1, 2, 2000);
        assertEquals(2, date.getMonth());
    }

    @Test
    void getYear() {
        Date date = new Date(1, 1, 2000);
        assertEquals(2000, date.getYear());
    }

    @Test
    void testToString() {
        Date date = new Date(1, 2, 2000);
        Date date2 = new Date(1, 2, 2000);
        assertEquals(date.toString(), date2.toString());
    }

    @Test
    void testEquals() {
        Date date = new Date(1, 1, 2000);
        Date date2 = new Date(1, 1, 2000);
        assertEquals(date, date2);
    }
}