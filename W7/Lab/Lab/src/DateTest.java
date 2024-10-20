import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DateTest {

    @Test
    void testGetDay() {
        Date date = new Date(1, 1, 2000);
        Assertions.assertEquals(1, date.getDay());
    }

    @Test
    void testGetMonth() {
        Date date = new Date(1, 2, 2000);
        Assertions.assertEquals(2, date.getMonth());
    }

    @Test
    void testGetYear() {
        Date date = new Date(1, 1, 2000);
        Assertions.assertEquals(2000, date.getYear());
    }

    @Test
    void testFromData() {
        String data = "24-10-2024";
        Date date = Date.fromData(data);
        Date date2 = new Date(24, 10, 2024);

        Assertions.assertEquals(date, date2);
    }

    @Test
    void testToString() {
        Date date = new Date(1, 2, 2000);
        Date date2 = new Date(1, 2, 2000);
        Assertions.assertEquals(date.toString(), date2.toString());
    }

    @Test
    void testEquals() {
        Date date = new Date(1, 1, 2000);
        Date date2 = new Date(1, 1, 2000);
        Assertions.assertEquals(date, date2);
    }
}