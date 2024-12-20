public class JackHammer extends Equipment{
    /**
     * Creates new JackHammer with the following properties
     *
     * @param requirements A textual description that indicates any special requirements the
     *                     piece of equipment should meet for this particular job
     */
    public JackHammer(String requirements) {
        super(requirements);
    }

    /**
     * Returns a readable text representation of the object
     * @return  String
     */
    @Override
    public String toString() {
        return "This JackHammer requires: " + requirements;
    }

    /**
     * Compares this object to the specified object for equality.
     * @param obj the object to compare this instance against
     * @return true if the given object is equal to this instance; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        JackHammer jackHamer = (JackHammer) obj;
        return requirements.equals(jackHamer.requirements);
    }
}
