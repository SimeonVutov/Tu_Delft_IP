public class Teacher extends Person {

    private int amountOfCourses;

    /**
     * Creates a new teacher.
     *
     * @param name The name of the teacher
     * @param height The height of the teacher
     * @param amountOfCourses The amount of courses the teacher teaches
     */
    public Teacher(String name, double height, int amountOfCourses) {
        super(name, height);
        this.amountOfCourses = amountOfCourses;
    }

    /**
     * Gets the amount of courses the teacher teaches.
     *
     * @return The amount of courses this teacher teaches
     */
    public int getAmountOfCourses() {
        return amountOfCourses;
    }

    /**
     * Sets the amount of courses the teacher teaches.
     *
     * @param amountOfCourses The new amount of courses this teacher teaches
     */
    public void setAmountOfCourses(int amountOfCourses) {
        this.amountOfCourses = amountOfCourses;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || this.getClass() == obj.getClass())
            return false;

        Teacher that = (Teacher) obj;

        if(super.equals(that) && this.amountOfCourses == that.amountOfCourses)
            return true;

        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ". Also he/she is a teacher who teaches " +
                amountOfCourses;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = result * 31 + amountOfCourses;

        return result;
    }
}
