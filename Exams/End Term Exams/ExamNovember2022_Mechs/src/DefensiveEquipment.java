import java.util.List;
import java.util.Objects;

public class DefensiveEquipment extends Equipment{
    private int defensePoints;

    /**
     * Creates new Equipment with the specified data
     *
     * @param name              the name of the equipment
     * @param equipmentID       the equipment id
     * @param strengths         the list of strengths
     * @param weaknesses        the list of weaknesses
     */
    protected DefensiveEquipment(String name,
                                 int equipmentID,
                                 List<String> strengths,
                                 List<String> weaknesses,
                                 int defensePoints
    ) {
        super(name, EquipmentCategory.DEFENSIVE, equipmentID, strengths, weaknesses);
        this.defensePoints = defensePoints;
    }

    /**
     * Creates a string representation of the object
     * @return a string
     */
    @Override
    public String toString() {
        return String.format(
                """
                %s
                Defense Points: %d
                """,
                super.toString(),
                defensePoints
        );
    }

    /**
     * Reads the stat of the equipment
     * @param data the data that will be used
     * @return an int representing the stat
     */
    public static int readStat(String data) {
        data = data.replaceAll("DEF", "");
        return Integer.parseInt(data);
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
        if (!super.equals(o)) return false;
        DefensiveEquipment that = (DefensiveEquipment) o;
        return defensePoints == that.defensePoints;
    }

    /**
     * Creates a hashcode for this object
     * @return the hashcode that is generated
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), defensePoints);
    }
}
