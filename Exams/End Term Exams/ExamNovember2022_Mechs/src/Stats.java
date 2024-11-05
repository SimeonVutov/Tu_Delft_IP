import java.util.Objects;

public class Stats {
    private int attackPoints;
    private int defensePoints;
    private int healthPoints;
    private int speedPoints;

    /**
     * Creates a new Stats object
     * @param attackPoints the attack points
     * @param defensePoints the defence points
     * @param healthPoints the health points
     * @param speedPoints the speed points
     */
    public Stats(int attackPoints, int defensePoints, int healthPoints, int speedPoints) {
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.healthPoints = healthPoints;
        this.speedPoints = speedPoints;
    }

    /**
     * Gets the attack points
     * @return int
     */
    public int getAttackPoints() {
        return attackPoints;
    }

    /**
     * Gets the defense points
     * @return int
     */
    public int getDefensePoints() {
        return defensePoints;
    }

    /**
     * Gets the health points
     * @return int
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Gets the speed points
     * @return int
     */
    public int getSpeedPoints() {
        return speedPoints;
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
        Stats stats = (Stats) o;
        return attackPoints == stats.attackPoints &&
                defensePoints == stats.defensePoints &&
                healthPoints == stats.healthPoints &&
                speedPoints == stats.speedPoints;
    }

    /**
     * Creates a hashcode for this object
     * @return the hashcode that is generated
     */
    @Override
    public int hashCode() {
        return Objects.hash(attackPoints,
                defensePoints,
                healthPoints,
                speedPoints);
    }
}
