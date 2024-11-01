import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

    @Test
    void readArtists() {
        String data = "ARTISTS Larry Mullen Jr.; The Edge; Bono; Adam Clayton";
        List<String> artists = List.of("Larry Mullen Jr.", "The Edge", "Bono", "Adam Clayton");

        assertEquals(artists, Album.readArtists(data));
    }

    @Test
    void read() {
        String data = """
                Billie Eilish; When We All Fall Asleep Where Do We Go?; 2018\s
                ARTISTS Billie Eilish; Finneas O'Connell\s
                TRACK 1; Bad Guy; 3:14\s
                TRACK 2; When the Party's Over; 3:16
                """.stripIndent();
        List<Track> tracks = List.of(
            new Track(new Duration(3, 14), "Bad Guy", 1),
            new Track(new Duration(3, 16), "When the Party's Over", 2)
        );
        List<String> artists = List.of("Billie Eilish", "Finneas O'Connell");

        Album album = new Album("Billie Eilish",
                "When We All Fall Asleep Where Do We Go?",
                2018,
                artists,
                tracks);
        Album album2 = Album.read(data);
        assertEquals(album, album2);

    }

    @Test
    void testHashCode() {
        String data = """
                Billie Eilish; When We All Fall Asleep Where Do We Go?; 2018\s
                ARTISTS Billie Eilish; Finneas O'Connell\s
                TRACK 1; Bad Guy; 3:14\s
                TRACK 2; When the Party's Over; 3:16
                """.stripIndent();
        List<Track> tracks = List.of(
                new Track(new Duration(3, 14), "Bad Guy", 1),
                new Track(new Duration(3, 16), "When the Party's Over", 2)
        );
        List<String> artists = List.of("Billie Eilish", "Finneas O'Connell");

        Album album = new Album("Billie Eilish",
                "When We All Fall Asleep Where Do We Go?",
                2018,
                artists,
                tracks);
        Album album2 = new Album("Billie Eilish",
                "When We All Fall Asleep Where Do We Go?",
                2018,
                artists,
                tracks);

        assertEquals(album.hashCode(), album2.hashCode());
    }

    @Test
    void testToString() {
        String data = """
                ALBUM Billie Eilish; When We All Fall Asleep Where Do We Go?; 2018
                ARTISTS Billie Eilish; Finneas O'Connell
                TRACK 1; Bad Guy; 03:14
                TRACK 2; When the Party's Over; 03:16""".stripIndent();
        Album album = Album.read("""
                Billie Eilish; When We All Fall Asleep Where Do We Go?; 2018
                ARTISTS Billie Eilish; Finneas O'Connell
                TRACK 1; Bad Guy; 03:14
                TRACK 2; When the Party's Over; 03:16
                """);

        assertEquals(data, album.toString());
    }
}