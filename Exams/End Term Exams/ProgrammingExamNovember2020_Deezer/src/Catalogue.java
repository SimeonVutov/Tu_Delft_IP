import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Catalogue {
    private List<Album> albums;
    private List<Track> tracks;
    private List<Ad> ads;
    private ArrayList<Media> currentPlayList;
    private boolean creatingPlaylist;

    public Catalogue(List<Album> albums, List<Ad> ads) {
        this.albums = albums;
        this.tracks = new ArrayList<>();
        for(var album : albums) {
            for(var track : album.getTracks()) {
                this.tracks.add(track);
            }
        }
        this.ads = ads;
        this.currentPlayList = new ArrayList<>();
        this.creatingPlaylist = false;
    }

    /**
     * Returns a track by the name
     * @param name the name of track
     * @return a track
     */
    public Track getTrackByName(String name) {
        for(var track : tracks) {
            if(track.getName().equals(name)) {
                return track;
            }
        }

        return null;
    }

    /**
     * Creates a string that will be directly saved in a file
     * @return a string for saving in file
     */
    public String toSaveString() {
        String result = "ALBUMS\n";
        for (var album : albums) {
            result += album.toString() + "\n";
        }
        result += "ADS\n";
        for (int i = 0; i < ads.size(); i++) {
            result += ads.get(i).toString();
            if(i < ads.size() - 1) {
                result += "\n";
            }
        }

        return result;
    }

    /**
     * Adds a new track to the playlist if the playlist is avaible
     * @param track the track that will be added
     * @throws Exception
     */
    public void addTrackToPlaylist(Track track) throws Exception {
        if(!creatingPlaylist) {
            currentPlayList.add(track);
        }
        else {
            throw new Exception("Cannot create a track right now!");
        }
    }

    /**
     * Creates a new playlist using randomness
     */
    public synchronized void createPlaylist() {
        Thread thread = new Thread(() -> {
            creatingPlaylist = true;
            Random rand = new Random(23432);
            for(int i = 0; i < 20; i++) {
                if(i % 2 == 0) {
                    int index = rand.nextInt(tracks.size());
                    currentPlayList.add(tracks.get(index));
                }
                else {
                    int index = rand.nextInt(ads.size());
                    currentPlayList.add(ads.get(index));
                }
            }
            creatingPlaylist = false;
        });

        thread.start();
    }

    /**
     * Checks if the specified object is equal to this
     * @param o the object we will check
     * @return true or false based on whether the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalogue catalogue = (Catalogue) o;
        return Objects.equals(albums, catalogue.albums) && Objects.equals(tracks, catalogue.tracks) && Objects.equals(ads, catalogue.ads);
    }

    /**
     * Creates a hash code based on class data
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(albums, tracks, ads);
    }

    /**
     * Calculate the sum of the commercial prices of ads
     * @return sum of commercial prices
     */
    public double calculatePrice() {
        List<Media> playlist = new ArrayList<>();
        for(var media : currentPlayList) {
            if(media instanceof Ad) {
                playlist.add((Ad) media);
            }
        }
        return currentPlayList.stream() // Stream<Media>
                .filter(m -> m instanceof Ad) // Stream<Media>
                .map(m -> (Ad) m) // Stream<Ad>
                .mapToDouble(Ad::getPrice) // StreamDouble<Ad>
                .sum();
    }
}
