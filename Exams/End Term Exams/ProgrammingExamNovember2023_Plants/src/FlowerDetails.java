import java.util.Scanner;

public record FlowerDetails(String colour, FlowerSize size, int numberOfPetals) {

    /**
     * Creates a new FlowerDetails object from the data
     * @param data data
     * @return new object
     */
    public static FlowerDetails read(String data) {
        data = data.replaceFirst("FLOWER DETAILS: ", "");
        Scanner sc = new Scanner(data);
        sc.useDelimiter("; ");
        String colour = sc.next();
        FlowerSize size = FlowerSize.valueOf(sc.next());
        int numberOfPetals = new Scanner(sc.next()).nextInt();

        return new FlowerDetails(colour, size, numberOfPetals);
    }

    /**
     * Creates a simple string representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return String.format(
                """
                This plant has %s, %s flowers with %d petals.
                """,
                size.name(),
                colour,
                numberOfPetals
        );
    }
}
