import java.util.Objects;
import java.util.Scanner;

public class Track extends Media {
    private int trackNumber;

    public Track(Duration duration, String name, int trackNumber) {
        super(duration, name);
        this.trackNumber = trackNumber;
    }

    /**
     * Creates a track based on the specified data
     * @param data the data
     * @return a new Track created from the data
     */
    public static Track read(String data) {
        data = data.replaceFirst("TRACK ", "");
        Scanner sc = new Scanner(data);
        sc.useDelimiter("; ");

        int trackNumber = Integer.parseInt(sc.next());
        String name = sc.next();
        Duration duration = Duration.read(sc.next());

        return new Track(duration, name, trackNumber);
    }

    /**
     * Creates a string representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return String.format("TRACK %d; %s; %s",
                trackNumber,
                getName(),
                getDuration().toString()
        );
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
        if (!super.equals(o)) return false;
        Track track = (Track) o;
        return trackNumber == track.trackNumber;
    }

    /**
     * Creates a hash code based on class data
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trackNumber);
    }
}
