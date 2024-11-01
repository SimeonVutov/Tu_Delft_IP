import java.util.Objects;
import java.util.Scanner;

public class Herb extends Plant{
    private boolean isSafeToEat;
    private String fragranceOrTasteNotes;

    /**
     * Creates a new herb object
     * @param name
     * @param latinName
     * @param sizeRange
     * @param flowerDetails
     * @param isSafeToEat
     * @param fragranceOrTasteNotes
     */
    public Herb(String name,
                String latinName,
                Range sizeRange,
                FlowerDetails flowerDetails,
                boolean isSafeToEat,
                String fragranceOrTasteNotes) {
        super(name, latinName, sizeRange, flowerDetails);
        this.isSafeToEat = isSafeToEat;
        this.fragranceOrTasteNotes = fragranceOrTasteNotes;
    }

    /**
     * Read the data and creates a new Herb object
     * @param data the data that will be read
     * @return new Herb object
     */
    public static Herb read(String data) {
        data = data.replaceFirst("HERB: ", "");
        String[] parts = data.split("\n");

        String name, latin, range, fragranceOrTasteNotes = "";
        boolean isSafeToEat = false;
        FlowerDetails flowerDetails = null;
        String line = parts[0];
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter("; ");

        name = lineScanner.next();
        latin = lineScanner.next();
        range = lineScanner.next();

        for(int i = 1; i < parts.length; i++) {
            line = parts[i];
            if(line.contains("FLOWER DETAILS:")) {
                flowerDetails = FlowerDetails.read(line);
            }
            else if(line.contains("EDIBILITY")) {
                lineScanner = new Scanner(line);
                lineScanner.useDelimiter("; ");

                String el = lineScanner.next();
                if(el.contains("Yes")) isSafeToEat = true;
                fragranceOrTasteNotes = lineScanner.next();
            }
        }

        return new Herb(name,
                latin,
                Range.read(range),
                flowerDetails,
                isSafeToEat,
                fragranceOrTasteNotes
                );
    }

    /**
     * Creates a simple string representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        String result = super.toString();
        result = "Herb " + result;
        if (isSafeToEat) {
            result += "This herb is safe to eat. ";
            result += fragranceOrTasteNotes;
        }

        return result;
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
        if (!super.equals(o)) return false;
        Herb herb = (Herb) o;
        return isSafeToEat == herb.isSafeToEat &&
                Objects.equals(
                        fragranceOrTasteNotes,
                        herb.fragranceOrTasteNotes);
    }

    /**
     * Creates a hashcode
     * @return a hashcode for the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isSafeToEat, fragranceOrTasteNotes);
    }
}
