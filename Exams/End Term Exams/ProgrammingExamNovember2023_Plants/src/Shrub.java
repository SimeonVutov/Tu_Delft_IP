import java.util.Scanner;

public class Shrub extends Plant {

    /**
     * Creates a new Shrub object
     * @param name name
     * @param latinName latin name
     * @param sizeRange range
     * @param flowerDetails flower details
     */
    public Shrub(String name, String latinName, Range sizeRange, FlowerDetails flowerDetails) {
        super(name, latinName, sizeRange, flowerDetails);
    }

    /**
     * Creates a tree from the given data
     * @param data the data that will be read
     * @return a new Shrub object
     */
    public static Shrub read(String data) {
        data = data.replaceFirst("SHRUB: ", "");
        String[] parts = data.split("\n");

        String name, latin, range;
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
        }

        return new Shrub(name,
                latin,
                Range.read(range),
                flowerDetails
        );
    }

    /**
     * Creates a simple string representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        String result = super.toString();
        result = "Shrub " + result;

        return result;
    }
}
