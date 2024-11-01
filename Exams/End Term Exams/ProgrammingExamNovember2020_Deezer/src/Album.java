import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Album {
    private String title;
    private String creator;
    private int year;
    private List<String> artists;
    private List<Track> tracks;

    public Album(String creator, String title, int year,
                 List<String> artists,
                 List<Track> tracks) {
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.artists = artists;
        this.tracks = tracks;
    }

    /**
     * Gets all the tracks in this album
     * @return
     */
    public List<Track> getTracks() {
        return tracks;
    }

    /**
     * Creates a new Album by reading from data
     * @param data data which we will read
     * @return a new Album
     */
    public static Album read(String data) {
        Scanner sc = new Scanner(data);
        List<String> artists = new ArrayList<>();
        List<Track> tracks = new ArrayList<>();

        String lineData = sc.nextLine();
        Scanner albumScanner = new Scanner(lineData);
        albumScanner.useDelimiter("; ");

        do{
            lineData = sc.nextLine();
            if(lineData.contains("ARTISTS")) {
                artists = readArtists(lineData);
            }
            else if(lineData.contains("TRACK")) {
                tracks.add(Track.read(lineData));
            }
        } while(sc.hasNextLine());
        return new Album(albumScanner.next(),
                albumScanner.next(),
                albumScanner.nextInt(),
                artists, tracks);
    }

    /**
     * Reads all the artists from the string data
     * @param data the artists data
     * @return a list of artists
     */
    public static List<String> readArtists(String data) {
        data = data.replaceFirst("ARTISTS ", "");
        Scanner sc = new Scanner(data);

        sc.useDelimiter("; ");

        List<String> artists = new ArrayList<>();
        while(sc.hasNextLine()) {
            artists.add(sc.next());
        }

        return artists;
    }

    /**
     * Creates a string representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        String artistsString = artists.toString();
        artistsString = artistsString.substring(1, artistsString.length() - 1);
        artistsString = artistsString.replaceAll(", ", "; ");

        String tracksString = "";
        for(int i = 0; i < tracks.size(); i++) {
            tracksString += tracks.get(i).toString();
            if(i < tracks.size() - 1) {
                tracksString += "\n";
            }
        }


        return String.format(
                "ALBUM %s; %s; %d\n" +
                        "ARTISTS %s\n" +
                        "%s",
                creator,
                title,
                year,
                artistsString,
                tracksString
        );
    }

    /**
     * Checks if the specified object is the same as this album object
     * @param o other obj
     * @return true/false based on whether the objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return year == album.year &&
                Objects.equals(title, album.title) &&
                Objects.equals(creator, album.creator) &&
                Objects.equals(artists, album.artists) &&
                Objects.equals(tracks, album.tracks);
    }

    /**
     * Creates a hashcode for the object
     * @return an int representing the hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, artists, tracks);
    }
}
