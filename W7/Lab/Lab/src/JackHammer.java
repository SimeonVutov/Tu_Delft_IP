public class JackHammer extends Equipment implements PowerSupply{
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
     * Gets the type of power supply needed for the equipment
     * @return  the type of the power supply
     */
    @Override
    public String getPowerSupply() {
        return "Air Compressor";
    }

    /**
     * Returns a readable text representation of the object
     * @return  String
     */
    @Override
    public String toString() {
        return "This JackHammer requires: " + requirements + "\n" +
                "PowerSupply: " + getPowerSupply() + "\n";
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
