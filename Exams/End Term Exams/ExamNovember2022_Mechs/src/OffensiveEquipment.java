import java.util.List;
import java.util.Objects;

public class OffensiveEquipment extends Equipment {
    private int attackPoints;
    /**
     * Creates new Offensive equipment with the specified data
     *
     * @param name the name of the equipment
     * @param equipmentID the equipment id
     * @param strengths the list of strengths
     * @param weaknesses the list of weaknesses
     * @param attackPoints the number of attackpoints
     */
    public OffensiveEquipment(String name,
                              int equipmentID,
                              List<String> strengths,
                              List<String> weaknesses,
                              int attackPoints) {
        super(name, EquipmentCategory.OFFENSIVE, equipmentID, strengths, weaknesses);
        this.attackPoints = attackPoints;
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
                Attack Points: %d
                """,
                super.toString(),
                attackPoints
        );
    }

    /**
     * Reads the stat of the equipment
     * @param data the data that will be used
     * @return an int representing the stat
     */
    public static int readStat(String data) {
        data = data.replaceAll("ATK", "");
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
        OffensiveEquipment that = (OffensiveEquipment) o;
        return attackPoints == that.attackPoints;
    }

    /**
     * Creates a hashcode for this object
     * @return the hashcode that is generated
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attackPoints);
    }
}
