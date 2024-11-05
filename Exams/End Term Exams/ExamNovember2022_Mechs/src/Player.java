import java.util.Objects;
import java.util.Optional;

public class Player {
    private Stats stats;
    private Optional<Equipment> attackEquipment;
    private Optional<Equipment> defenceEquipment;

    /**
     * Creates a new Entity object
     * @param stats the stats of the player
     */
    public Player(Stats stats) {
        this.stats = stats;
        attackEquipment = Optional.empty();
        defenceEquipment = Optional.empty();
    }

    /**
     * Creates a string representation of the object
     * @return a string
     */
    @Override
    public String toString() {
        String attackEquipmentStr;
        String defenseEquipmentStr;

        if(attackEquipment.isEmpty()) {
            attackEquipmentStr = "Not equiped";
        }
        else attackEquipmentStr = attackEquipment.get().toString();

        if(defenceEquipment.isEmpty()) {
            defenseEquipmentStr = "Not equiped";
        }
        else defenseEquipmentStr = defenceEquipment.get().toString();

        return String.format(
                """
                Player stats:
                    %d Attack
                    %d Defense
                    %d Health
                    %d Speed
                    Equipments:
                        Attack: %s
                        Defense: %s""",
                stats.getAttackPoints(),
                stats.getDefensePoints(),
                stats.getHealthPoints(),
                stats.getSpeedPoints(),
                attackEquipmentStr,
                defenseEquipmentStr
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
        Player player = (Player) o;
        return Objects.equals(stats, player.stats) &&
                Objects.equals(attackEquipment, player.attackEquipment) &&
                Objects.equals(defenceEquipment, player.defenceEquipment);
    }

    /**
     * Creates a hashcode for this object
     * @return the hashcode that is generated
     */
    @Override
    public int hashCode() {
        return Objects.hash(stats, attackEquipment, defenceEquipment);
    }
}
