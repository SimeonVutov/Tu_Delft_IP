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
}