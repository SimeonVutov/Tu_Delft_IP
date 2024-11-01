import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PlantCollection {
    private List<Plant> allPlants;
    private List<Plant> filteredPlants;

    /**
     * Creates a new PlantCollection
     * @param allPlants all plants
     */
    public PlantCollection(List<Plant> allPlants) {
        this.allPlants = allPlants;
        this.filteredPlants = new ArrayList<>();
    }

    /**
     * Reads all the plants from the specified data string
     * @param data the string from which we will read plants
     * @return a list of all plants
     */
    public static List<Plant> readPlants(String data) {
        List<Plant> allPlants = new ArrayList<>();
        Scanner sc = new Scanner(data);
        String currentLine;
        String plantDataString;

        while(sc.hasNextLine()) {
            currentLine = sc.nextLine();

            if(currentLine.contains("HERB")) {
                plantDataString = currentLine + "\n";
                plantDataString += getPlantBeforeNext(sc);

                allPlants.add(Herb.read(plantDataString));
            }
            else if(currentLine.contains("TREE")) {
                plantDataString = currentLine + "\n";
                plantDataString += getPlantBeforeNext(sc);

                allPlants.add(Tree.read(plantDataString));
            }
            else if(currentLine.contains("SHRUB")) {
                plantDataString = currentLine + "\n";
                plantDataString += getPlantBeforeNext(sc);
                allPlants.add(Shrub.read(plantDataString));
            }
        }

        return allPlants;
    }

    /**
     * Reads only one plant from the scanner
     * @param sc the scanner
     * @return a string containing all of the additional data for the plant
     */
    public static String getPlantBeforeNext(Scanner sc) {
        String result = "";
        String line;
        Scanner lineScanner;

        while(sc.hasNextLine() && (
            !sc.hasNext("TREE:") &&
            !sc.hasNext("SHRUB:") &&
            !sc.hasNext("HERB:")
            )
        ) {
            line = sc.nextLine();
            lineScanner = new Scanner(line);
            lineScanner.useDelimiter("\n");

            if(lineScanner.hasNext("^FLOWER DETAILS:.*$") ||
                    lineScanner.hasNext("^EDIBILITY:.*$")) {
                result += line + "\n";
            }
            else {
                break;
            }
        }

        if(!result.isEmpty()) {
            return result.substring(0, result.length() - 1);
        }
        return result;
    }

    /**
     * Remove all filters that were applied to the collection
     */
    public void resetFilters() {
        filteredPlants = allPlants;
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
        PlantCollection that = (PlantCollection) o;
        return Objects.equals(allPlants, that.allPlants) &&
                Objects.equals(filteredPlants, that.filteredPlants);
    }

    /**
     * Creates a hashcode
     * @return a hashcode for the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(allPlants, filteredPlants);
    }

    /**
     * Creates a simple string representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        String result = "";
        for (Plant plant : filteredPlants) {
            result += plant + "\n";
        }

        return result;
    }
}
