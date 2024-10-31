import java.util.Objects;
import java.util.Scanner;

public class Ad extends Media {
    private double price;

    public Ad(Duration duration, String name, double price) {
        super(duration, name);
        this.price = price;
    }

    /**
     * Returns the commercial price of the ad
     * @return commercial price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Creates a new Ad by reading from data
     * @param data the data that will be read
     * @return a new Ad object
     */
    public static Ad read(String data) {
        data = data.replaceFirst("AD ", "");
        Scanner sc = new Scanner(data);
        sc.useDelimiter("; ");

        String name = sc.next();
        Duration duration = Duration.read(sc.next());
        double price = new Scanner(sc.next()).nextDouble();

        return new Ad(duration, name, price);
    }

    /**
     * Creates a string representation of the ad
     * @return a string representation of the ad
     */
    @Override
    public String toString() {
        return String.format("AD %s; %s; %.2f euros",
                getName(),
                getDuration().toString(),
                price
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
        Ad ad = (Ad) o;
        return Double.compare(price, ad.price) == 0;
    }

    /**
     * Creates a hash code based on class data
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }
}
