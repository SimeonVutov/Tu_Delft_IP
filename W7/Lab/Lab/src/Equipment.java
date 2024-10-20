public abstract class Equipment {
    protected String requirements;

    /**
     * Creates new Equipment with the following properties
     * @param requirements      A textual description that indicates any special requirements the
     * piece of equipment should meet for this particular job
     */
    public Equipment(String requirements) {
        this.requirements = requirements;
    }

    /**
     * Returns a string representation of the requirement in special format for writing in file
     * @return string representation of the requirement in special format
     */
    public String serialize() {
        return getClass().getSimpleName().toString() + ", " + requirements + ";";
    }
}