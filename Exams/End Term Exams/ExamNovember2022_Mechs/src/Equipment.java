import java.util.List;
import java.util.Objects;

public abstract class Equipment {
    protected String name;
    protected EquipmentCategory equipmentCategory;
    protected int equipmentID;
    protected List<String> strengths;
    protected List<String> weaknesses;

    /**
     * Creates a new Equipment with the specified data
     * @param name the name of the equipment
     * @param equipmentCategory the equipment category
     * @param equipmentID the equipment id
     * @param strengths the list of strengths
     * @param weaknesses the list of weaknesses
     */
    protected Equipment(String name,
                        EquipmentCategory equipmentCategory,
                        int equipmentID,
                        List<String> strengths,
                        List<String> weaknesses
    ) {
        this.name = name;
        this.equipmentCategory = equipmentCategory;
        this.equipmentID = equipmentID;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
    }

    /**
     * Creates a string representation of the object
     * @return string
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
                Equipment: %s
                    category: %s
                    id: %d
                    strengths: %s
                    weaknesses: %s""",
                name,
                equipmentCategory,
                equipmentID,
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
        Equipment equipment = (Equipment) o;
        return equipmentID == equipment.equipmentID &&
                Objects.equals(name, equipment.name) &&
                Objects.equals(strengths, equipment.strengths) &&
                Objects.equals(weaknesses, equipment.weaknesses);
    }

    /**
     * Creates a hashcode for this object
     * @return the hashcode that is generated
     */
    @Override
    public int hashCode() {
        return Objects.hash(name,
                equipmentID,
                strengths,
                weaknesses);
    }
}
