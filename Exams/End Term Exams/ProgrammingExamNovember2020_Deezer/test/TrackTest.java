import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    @Test
    void testToString() {
        Track track = new Track(new Duration(4, 15), "The Miracle", 1);
        String data = "TRACK 1; The Miracle; 04:15";

        assertEquals(data, track.toString());
    }

    @Test
    void read() {
        String data = "TRACK 1; The Miracle; 04:15";
        Track track = new Track(new Duration(4, 15), "The Miracle", 1);

        assertEquals(track, Track.read(data));
    }

    @Test
    void testHashCode() {
        Track track = new Track(new Duration(1, 24), "Test", 1);
        Track track2 = new Track(new Duration(1, 24), "Test", 1);

        assertEquals(track.hashCode(), track2.hashCode());
    }
}