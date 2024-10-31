import org.junit.jupiter.api.Test;

import java.awt.dnd.DragGestureEvent;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatalogueTest {

    @Test
    void testGetTrackByName() {
        Track track = new Track(new Duration(4, 15), "The Miracle", 1);
        Ad ad = new Ad(new Duration(0, 20), "ING Bank", 0.05);
        Album album = new Album(
                "U2",
                "Songs of Innocence",
                2014,
                List.of("Larry Mullen Jr.", "The Edge", "Bono", "Adam Clayton"),
                List.of(track)
        );

        Catalogue catalogue = new Catalogue(List.of(album), List.of(ad));

        assertEquals(track, catalogue.getTrackByName("The Miracle"));
    }

    @Test
    void testCalculatePrice() throws InterruptedException {
//        Ad ad = new Ad(new Duration(0, 20), "ING Bank", 0.05);
//        Ad ad2 = new Ad(new Duration(0, 20), "ING Bank", 1);
//        Catalogue catalogue = new Catalogue(new ArrayList<>(), List.of(ad, ad2));
//        catalogue.createPlaylist();
//        assertEquals(1.05, catalogue.calculatePrice(), 0.001);
    }

    @Test
    void toSaveString() {
        String data = """
                ALBUMS
                ALBUM U2; Songs of Innocence; 2014
                ARTISTS Larry Mullen Jr.; The Edge; Bono; Adam Clayton
                TRACK 1; The Miracle; 04:15
                ADS
                AD ING Bank; 00:20; 0.05 euros""";
        Track track = new Track(new Duration(4, 15), "The Miracle", 1);
        Ad ad = new Ad(new Duration(0, 20), "ING Bank", 0.05);
        Album album = new Album(
                "U2",
                "Songs of Innocence",
                2014,
                List.of("Larry Mullen Jr.", "The Edge", "Bono", "Adam Clayton"),
                List.of(track)
        );

        Catalogue catalogue = new Catalogue(List.of(album), List.of(ad));

        assertEquals(data, catalogue.toSaveString());
    }

    @Test
    void createPlaylist() {

    }

    @Test
    void testHashCode() {
        Catalogue catalogue = new Catalogue(new ArrayList<>(), new ArrayList<>());
        Catalogue catalogue2 = new Catalogue(new ArrayList<>(), new ArrayList<>());

        assertEquals(catalogue.hashCode(), catalogue2.hashCode());
    }
}