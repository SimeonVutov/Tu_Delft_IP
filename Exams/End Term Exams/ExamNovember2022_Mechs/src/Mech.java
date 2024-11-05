import java.util.*;

public class Mech {
    private String name;
    private String category;
    private Stats stats;
    private int lootDropId;
    private List<String> strengths;
    private List<String> weaknesses;


    /**
     * Creates a new Mech object with the specified data
     * @param name name of the Mech
     * @param category the category of the mech
     * @param lootDropId the loot drop id
     * @param stats an object containing the stats of the Mech
     * @param strengths the list of strengths of the Mech
     * @param weaknesses the list of weaknesses of the Mech
     */
    public Mech(
            String name,
            String category,
            int lootDropId,
            Stats stats,
            List<String> strengths,
            List<String> weaknesses
    ) {
        this.name = name;
        this.stats = stats;
        this.category = category;
        this.lootDropId = lootDropId;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
    }

    /**
     * Creates a new Mech by using the data
     * @param data the data that will be used to create the Mech
     * @return a new Mech object
     */
    public static Mech read(String data) {
        Scanner mainScanner = new Scanner(data);
        String line = mainScanner.nextLine();
        line = line.replaceFirst("MECH - ", "");
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(" - ");

        String name = lineScanner.next();
        String category = lineScanner.next();
        int lootDropId = Integer.parseInt(lineScanner.next());

        line = mainScanner.nextLine();
        Stats stats = readStats(line);

        List<String> strengths = new ArrayList<>();
        List<String> weaknesses = new ArrayList<>();
        line = mainScanner.nextLine();
        if(!line.isEmpty()) {
            strengths = DataReader.readStrengths(line);
            weaknesses = DataReader.readWeaknesses(line);
        }

        return new Mech(
                name,
                category,
                lootDropId,
                stats,
                strengths,
                weaknesses
        );
    }

    /**
     * Read the line with the stats of the mech
     * @param data the line of the stats
     * @return a stats object
     */
    public static Stats readStats(String data) {
        data = data.replaceAll("ATK", "");
        data = data.replaceAll("DEF", "");
        data = data.replaceAll("HP", "");
        data = data.replaceAll("SPD", "");
        Scanner sc = new Scanner(data);
        sc.useDelimiter(" - ");
        List<Integer> stats = new ArrayList<>();

        while(sc.hasNext()) {
            stats.add(Integer.parseInt(sc.next()));
        }

        return new Stats(stats.get(0),
                stats.get(1),
                stats.get(2),
                stats.get(3)
        );
    }

    /**
     * Creates a string representation of the object
     * @return a string
     */
    @Override
    public String toString() {
        String strengthsStr = "none";
        String weaknessesStr = "none";
        if(strengths.size() > 0) {
            strengthsStr = strengths.toString().substring(1, strengths.toString().length() - 1);
        }
        if(weaknesses.size() > 0) {
            weaknessesStr = weaknesses.toString().substring(1, weaknesses.toString().length() - 1);
        }
        return String.format(
                """
                %s (Category: %s)
                It has %d attack, %d defence, %d health, and %d speed.
                strength(s): %s, weakness(es): %s""",
                name,
                category,
                stats.getAttackPoints(),
                stats.getDefensePoints(),
                stats.getHealthPoints(),
                stats.getSpeedPoints(),
                strengthsStr,
                weaknessesStr
        );
    }

    /**
     * Checks if the specified object is the same as this
     * @param o the other object
     * @return true or false depends on whether the two objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mech mech = (Mech) o;
        return lootDropId == mech.lootDropId &&
                Objects.equals(name, mech.name) &&
                Objects.equals(category, mech.category) &&
                Objects.equals(stats, mech.stats) &&
                Objects.equals(strengths, mech.strengths) &&
                Objects.equals(weaknesses, mech.weaknesses);
    }

    /**
     * Creates a hashcode for this object
     * @return the hashcode that is generated
     */
    @Override
    public int hashCode() {
        return Objects.hash(name,
                category,
                stats,
                lootDropId,
                strengths,
                weaknesses);
    }
}
