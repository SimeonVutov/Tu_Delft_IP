public class Person {

    private String name;
    private double height;

    /**
     * Creates a person.
     *
     * @param name The name of the person
     * @param height The height of the person
     */
    public Person(String name, double height) {
        this.name = name;
        this.height = height;
    }

    /**
     * Gets the name of the person.
     *
     * @return This person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the height of the person.
     *
     * @return This person's height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the person.
     *
     * @param height The new height for this person
     */
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || this.getClass() == obj.getClass())
            return false;

        Student that = (Student) obj;

        if(this.name.equals(that.getName()) && this.height == that.getHeight())
            return true;

        return false;
    }

    @Override
    public String toString() {
        return name + "is " + height + " meters tall";
    }

    public int hashCode() {
        int hash = super.hashCode();
        hash = hash * 31 + name.hashCode();
        hash = hash * 31 + height;
        return hash;
    }
}
