public class Torch extends Equipment implements PowerSupply {

    /**
     * Creates new Torch equipment with the following properties
     *
     * @param requirements A textual description that indicates any special requirements the
     *                     piece of equipment should meet for this particular job
     */
    public Torch(String requirements) {
        super(requirements);
    }

    /**
     * Gets the type of power supply the equipment needs
     * @return the type of power supply
     */
    @Override
    public String getPowerSupply() {
        return "Butane Gas";
    }

    /**
     * Returns a readable text representation of the object
     * @return  String
     */
    @Override
    public String toString() {
        return "This torch requires: " + requirements + "\n" +
                "PowerSupply: " + getPowerSupply();
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

        Torch torch = (Torch) obj;
        return requirements.equals(torch.requirements);
    }

}
