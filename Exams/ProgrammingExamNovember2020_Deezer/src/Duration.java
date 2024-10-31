import java.util.Objects;
import java.util.Scanner;

public class Duration {
    private int minutes;
    private int seconds;

    /**
     * Creates a new Duration object by passing some arguments
     * @param minutes the minutes
     * @param seconds the seconds
     */
    public Duration(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * Creates a new Duration object from the data
     * @param data the data that will be used
     * @return a new Duration object
     */
    public static Duration read(String data) {
        String[] dataArr = data.split(":");

        return new Duration(
                Integer.parseInt(dataArr[0]),
                Integer.parseInt(dataArr[1])
        );
    }

    /**
     * Creates a string representation of the class
     * @return a string representation of the class
     */
    @Override
    public String toString() {
        String minutesStr = String.valueOf(minutes);
        String secondsStr = String.valueOf(seconds);
        if(minutes < 10) {
            minutesStr = "0" + minutes;
        }
        if(seconds < 10) {
            secondsStr = "0" + seconds;
        }
        return String.format("%s:%s", minutesStr, secondsStr);
    }

    /**
     * Checks if the specified object is the same as this Duration object
     * @param o other obj
     * @return true/false based on whether the objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duration duration = (Duration) o;
        return minutes == duration.minutes && seconds == duration.seconds;
    }

    /**
     * Creates a hash code based on class data
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(minutes, seconds);
    }
}
