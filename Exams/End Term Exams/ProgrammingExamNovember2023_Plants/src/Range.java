import java.util.Objects;
import java.util.Scanner;

public class Range {
    private int min;
    private int max;

    /**
     * Creates a new Range
     * @param min min
     * @param max max
     */
    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Creates a new range from the data
     * @param data data
     * @return a new Range
     */
    public static Range read(String data) {
        data = data.substring(1, data.length() - 1);
        Scanner scanner = new Scanner(data);
        scanner.useDelimiter(", ");
        return new Range(scanner.nextInt(), scanner.nextInt());
    }

    /**
     * Creates a simple string representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return String.format("%dcm and %dcm", min, max);
    }

    /**
     * Checks if the given object is equal to this object
     * @param o the object that we are going to compare this to
     * @return true/false based on whether the objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return min == range.min && max == range.max;
    }

    /**
     * Creates a hashcode
     * @return a hashcode for the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }
}
