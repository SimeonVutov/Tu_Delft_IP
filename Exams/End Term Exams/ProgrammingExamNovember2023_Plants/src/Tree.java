import java.util.Scanner;

public class Tree extends Plant{
    /**
     * Creates a new Tree object
     * @param name name
     * @param latinName latin name
     * @param sizeRange range
     * @param flowerDetails flower details
     */
    public Tree(String name, String latinName, Range sizeRange, FlowerDetails flowerDetails) {
        super(name, latinName, sizeRange, flowerDetails);
    }

    /**
     * Creates a tree from the given data
     * @param data the data that will be read
     * @return a new Tree object
     */
    public static Tree read(String data) {
        data = data.replaceFirst("TREE: ", "");
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

        return new Tree(name,
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
        result = "Tree " + result;

        return result;
    }
}
